package com.woocommerce;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.woocommerce.auth.AuthParamsKey;
import com.woocommerce.auth.BasicAuthConfig;

public class WooCommerceAPI implements WooCommerce {

	private static final String API_URL_FORMAT = "%s/wp-json/wc/v1/%s?%s";
	private static final String API_URL_ONE_ENTITY_FORMAT = "%s/wp-json/wc/v1/%s/%d";
	private static final String URL_SECURED_FORMAT = "%s=%s&%s=%s";
	private static final String API_URL_PARAMS = "&%s=%s";

	private HttpsClient client;
	private BasicAuthConfig config;

	public WooCommerceAPI(BasicAuthConfig config) throws IOException {
		this.config = config;
		this.client = new DefaultHttpsClient();
	}

	@Override
	public Object get(EndpointBaseType endpointBaseType, int id) throws IOException {
		String https_url = String.format(API_URL_ONE_ENTITY_FORMAT, config.getUrl(), endpointBaseType.getValue(), id, getCredentialsString());
		
		URL url = new URL(https_url);
		return client.get(url, endpointBaseType);
	}

	@Override
	public List<?> getAll(EndpointBaseType endpointBaseType, Map<String, String> params) throws ProtocolException, MalformedURLException, IOException {
		String https_url = String.format(API_URL_FORMAT, config.getUrl(), endpointBaseType.getValue(), getCredentialsString());
		URL url = new URL(https_url + getParamsAsString(params));
		return client.getAll(url, endpointBaseType);
	}
	
	@Override
	public Object update(EndpointBaseType endpointBaseType, int id, Object object) {
		String url = String.format(API_URL_ONE_ENTITY_FORMAT, config.getUrl(), endpointBaseType.getValue(), id);
		Map<String,String> params = new HashMap<String, String>();
		params.putAll(getCredentialsMap());
		return client.put(url, params, object);
	}
	
//	@Override
//	public Map create(String endpointBase, Map<String, Object> object) {
//		String url = String.format(API_URL_FORMAT, config.getUrl(), endpointBase);
//		URL url = new URL(https_url);
//		return client.post(url);
//	}
	
//	@Override
//	public Map delete(String endpointBase, int id) {
//		String url = String.format(API_URL_ONE_ENTITY_FORMAT, config.getUrl(), endpointBase, id);
//		Map<String, String> params = BasicAuthSignature.getAsMap(config, url, HttpsMethod.DELETE);
//		return client.delete(url, params);
//	}

	private String getCredentialsString() {
		String credentials = String.format(URL_SECURED_FORMAT, AuthParamsKey.CONSUMER_KEY.getValue(),
				config.getConsumerKey(), AuthParamsKey.CONSUMER_SECRET.getValue(), config.getConsumerSecret()); 
		return credentials;
	}
	
	private String getParamsAsString(Map<String, String> params) {
		StringBuffer ret = new StringBuffer();
		for (String key : params.keySet()) {
			ret.append(String.format(API_URL_PARAMS, key, params.get(key)));
		}
		return ret.toString();
	}

	private Map<? extends String, ? extends String> getCredentialsMap() {
		Map<String,String> credentials = new HashMap<String, String>();
		credentials.put(AuthParamsKey.CONSUMER_KEY.getValue(), config.getConsumerKey());
		credentials.put(AuthParamsKey.CONSUMER_SECRET.getValue(), config.getConsumerSecret());
		return credentials;
	}
}
