package com.woocommerce;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
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

public class DefaultHttpsClient implements HttpsClient {

	private HttpsURLConnection httpsConnection;
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Object get(URL url, EndpointBaseType endpointBaseType) throws IOException {
		this.httpsConnection = (HttpsURLConnection)url.openConnection();
		addConnectionParams();
		this.httpsConnection.setRequestMethod(HttpGet.METHOD_NAME);
		return getEntityAndReleaseConnection(endpointBaseType, false);
	}

	@Override
	public List<?> getAll(URL url, EndpointBaseType endpointBaseType) throws ProtocolException, IOException {
		this.httpsConnection = (HttpsURLConnection)url.openConnection();
		addConnectionParams();
		this.httpsConnection.setRequestMethod(HttpGet.METHOD_NAME);
		return getEntityAndReleaseConnection(endpointBaseType, true);
	}

//	@Override
//	public Map post(String url, Map<String, String> params, Map<String, Object> object) {
//		List<NameValuePair> postParameters = getParametersAsList(params);
//		HttpPost httpPost;
//		try {
//			URIBuilder uriBuilder = new URIBuilder(url);
//			uriBuilder.addParameters(postParameters);
//			httpPost = new HttpPost(uriBuilder.build());
//			httpPost.setHeader("Content-Type", "application/json");
//			return postEntity(object, httpPost);
//		} catch (URISyntaxException e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	public Object put(String url, Map<String, String> params, Object object) {
		List<NameValuePair> postParameters = getParametersAsList(params);
		HttpPut httpPut;
		try {
			URIBuilder uriBuilder = new URIBuilder(url);
			uriBuilder.addParameters(postParameters);
			httpPut = new HttpPut(uriBuilder.build());
			httpPut.setHeader("Content-Type", "application/json");
			return postEntity(object, httpPut);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

//	@Override
//	public Map delete(String url, Map<String, String> params) {
//		List<NameValuePair> postParameters = getParametersAsList(params);
//		HttpDelete httpDelete;
//		try {
//			URIBuilder uriBuilder = new URIBuilder(url);
//			uriBuilder.addParameters(postParameters);
//			httpDelete = new HttpDelete(uriBuilder.build());
//			return getEntityAndReleaseConnection(EndpointBaseType.ORDERS, true);
//		} catch (URISyntaxException e) {
//			throw new RuntimeException(e);
//		}
//	}

	private Object postEntity(Object objectForJson, HttpEntityEnclosingRequestBase httpRequest) {
		HttpEntity entity;
		Object ret = null;
		try {
			entity = new ByteArrayEntity(this.mapper.writeValueAsBytes(objectForJson), ContentType.APPLICATION_JSON);
			httpRequest.setEntity(entity);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(httpRequest);
				InputStream inputStream = response.getEntity().getContent();) {
			ret = parseResponse(EndpointBaseType.ORDERS, false, inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return ret;
	}

	private List<NameValuePair> getParametersAsList(Map<String, String> params) {
		List<NameValuePair> postParameters = new ArrayList<>();
		if (params != null && params.size() > 0) 
			for (String key : params.keySet())
				postParameters.add(new BasicNameValuePair(key, params.get(key)));
		return postParameters;
	}

	private <T> T getEntityAndReleaseConnection(EndpointBaseType endpointBaseType, boolean isList) {
		if (httpsConnection == null) return null;
		addConnectionParams();
		T result = null;
		try (InputStream inputStream = httpsConnection.getInputStream()) {
			result = parseResponse(endpointBaseType, isList, inputStream);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("Can't parse retrieved object.", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error retrieving results from https request", e);
		} finally {
			httpsConnection.disconnect();
		}
		return (T)result;
	}

	@SuppressWarnings("unchecked")
	private <T> T parseResponse(EndpointBaseType endpointBaseType, boolean isList, InputStream inputStream)
			throws IOException, JsonParseException, JsonMappingException {
		T result;
		if (isList){
			JavaType type = mapper.getTypeFactory().constructParametricType(List.class, endpointBaseType.getClazz());
			result = mapper.readValue(inputStream, type);
		}
		else {
			result = mapper.readValue(inputStream, (Class<T>) endpointBaseType.getClazz());
		}
		return result;
	}

	private void addConnectionParams(){
		this.httpsConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
	}
}
