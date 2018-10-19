package com.woocommerce;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woocommerce.auth.AuthParamsKey;
import com.woocommerce.auth.BasicAuthConfig;

public class DefaultHttpsClient implements HttpsClient {

	private BasicAuthConfig config;
	
	public DefaultHttpsClient(BasicAuthConfig config) {
		this.config = config;
	}

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Object get(String url, EndPointBaseType endPointBaseType) {
		HttpGet httpGet = new HttpGet(buildURI(url));
		return doHttpRequest(endPointBaseType, httpGet);
	}

	@Override
	public List<?> getAll(String url, Map<String, String> params,  EndPointBaseType endPointBaseType) {
		HttpGet httpGet = new HttpGet(buildURI(url, params));
		return doHttpRequest(endPointBaseType, httpGet, true);
	}
	
	@Override
	public Object put(String url, EndPointBaseType endPointBaseType, Object object) {
		HttpPut httpPut = new HttpPut(buildURI(url));
		httpPut.setEntity(convertObjectToJsonHttpEntity(object));
		return doHttpRequest(endPointBaseType, httpPut);
	}

	@Override
	public Object post(String url, EndPointBaseType endPointBaseType, Object object) {
		HttpPost httpPost = new HttpPost(buildURI(url));
		httpPost.setEntity(convertObjectToJsonHttpEntity(object));
		return doHttpRequest(endPointBaseType, httpPost);
	}
	
	@Override
	public Object delete(String url, EndPointBaseType endPointBaseType) {
		HttpDelete httpDelete = new HttpDelete(buildURI(url));
		return doHttpRequest(endPointBaseType, httpDelete);
	}

	private <T> T doHttpRequest(EndPointBaseType endPointBaseType, HttpRequestBase httpRequest) {
		return doHttpRequest(endPointBaseType, httpRequest, false);
	}

	private <T> T doHttpRequest(EndPointBaseType endPointBaseType, HttpRequestBase httpRequest, boolean isList) {
		httpRequest.setHeader("Content-Type", "application/json");
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(httpRequest);
				InputStream inputStream = response.getEntity().getContent();) {
			return parseResponse(endPointBaseType, isList, inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
	}
	
	@SuppressWarnings("unchecked")
	private <T> T parseResponse(EndPointBaseType endpointBaseType, boolean isList, InputStream inputStream) 
			throws IOException, JsonParseException, JsonMappingException {
		if (isList){
			JavaType type = mapper.getTypeFactory().constructParametricType(List.class, endpointBaseType.getClazz());
			return mapper.readValue(inputStream, type);
		}
		else return mapper.readValue(inputStream, (Class<T>) endpointBaseType.getClazz());
	}

	private URI buildURI(String url){
		return buildURI(url, null);
	}
			
	private URI buildURI(String url, Map<String, String> params) {
		List<NameValuePair> postParameters = getParametersAsList(params);
		try {
			URIBuilder uriBuilder = new URIBuilder(url);
			addCredentialsParams(uriBuilder);
			uriBuilder.addParameters(postParameters);
			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	private void addCredentialsParams(URIBuilder uriBuilder) {
		uriBuilder.addParameter(AuthParamsKey.CONSUMER_KEY.getValue(), this.config.getConsumerKey());
		uriBuilder.addParameter(AuthParamsKey.CONSUMER_SECRET.getValue(), this.config.getConsumerSecret());
	}

	private List<NameValuePair> getParametersAsList(Map<String, String> params) {
		List<NameValuePair> postParameters = new ArrayList<>();
		if (params != null && params.size() > 0) 
			for (String key : params.keySet())
				postParameters.add(new BasicNameValuePair(key, params.get(key)));
		return postParameters;
	}
	
	private HttpEntity convertObjectToJsonHttpEntity(Object objectToJson) {
		HttpEntity entity;
		try {
			entity = new ByteArrayEntity(this.mapper.writeValueAsBytes(objectToJson), ContentType.APPLICATION_JSON);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Failed convert objec to json http entity. object: " + objectToJson.toString(), e);
		}
		return entity;
	}
}