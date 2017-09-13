package com.woocommerce;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import com.woocommerce.auth.AuthParamsKey;
import com.woocommerce.auth.BasicAuthConfig;
import com.woocommerce.beans.order.OrderParamsKeys;

public class WooCommerceAPI implements WooCommerce {

	private static final String API_URL_FORMAT = "%s/wp-json/wc/v1/%s?%s";
	private static final String API_URL_ONE_ENTITY_FORMAT = "%s/wp-json/wc/v1/%s/%d?%s";
	private static final String URL_SECURED_FORMAT = "%s=%s&%s=%s";
	private static final String API_URL_PARAMS = "&%s=%s";

	private HttpsClient client;
	private BasicAuthConfig config;

	public WooCommerceAPI(BasicAuthConfig config) throws IOException {
		this.config = config;
		this.client = new DefaultHttpsClient();
	}

	//	@Override
	//	public Map create(String endpointBase, Map<String, Object> object) {
	//		String url = String.format(API_URL_FORMAT, config.getUrl(), endpointBase);
	//		URL url = new URL(https_url);
	//		return client.post(url);
	//	}

	@Override
	public Object get(EndpointBaseType endpointBaseType, int id) throws IOException {
		String https_url = String.format(API_URL_ONE_ENTITY_FORMAT, config.getUrl(), endpointBaseType.getValue(), id, getCredentials());
		
		URL url = new URL(https_url);
		return client.get(url, endpointBaseType);
	}

	@Override
	public List<?> getAll(EndpointBaseType endpointBaseType, Map params) throws ProtocolException, MalformedURLException, IOException {
		String https_url = String.format(API_URL_FORMAT, config.getUrl(), endpointBaseType.getValue(), getCredentials());
		URL url = new URL(https_url + getParamsString(params));
		return client.getAll(url, endpointBaseType);
	}

	private String getCredentials() {
		String credentials = String.format(URL_SECURED_FORMAT, AuthParamsKey.CONSUMER_KEY.getValue(),
				config.getConsumerKey(), AuthParamsKey.CONSUMER_SECRET.getValue(), config.getConsumerSecret()); 
		return credentials;
	}
	
	private String getParamsString(Map<OrderParamsKeys, String> params) {
		StringBuffer ret = new StringBuffer();
		for (OrderParamsKeys key : params.keySet()) {
			ret.append(String.format(API_URL_PARAMS,key.getValue(),params.get(key)));
		}
		return ret.toString();
	}

	//	@Override
	//	public Map update(String endpointBase, int id, Map<String, Object> object) {
	//		String url = String.format(API_URL_ONE_ENTITY_FORMAT, config.getUrl(), endpointBase, id);
	//		return client.put(url, BasicAuthSignature.getAsMap(config, url, HttpsMethod.PUT), object);
	//	}

	//	@Override
	//	public Map delete(String endpointBase, int id) {
	//		String url = String.format(API_URL_ONE_ENTITY_FORMAT, config.getUrl(), endpointBase, id);
	//		Map<String, String> params = BasicAuthSignature.getAsMap(config, url, HttpsMethod.DELETE);
	//		return client.delete(url, params);
	//	}

	private static void print_https_cert(HttpsURLConnection con){

		if(con!=null){

			try {

				System.out.println("Response Code : " + con.getResponseCode());
				System.out.println("Cipher Suite : " + con.getCipherSuite());
				System.out.println("\n");

				Certificate[] certs = con.getServerCertificates();
				for(Certificate cert : certs){
					System.out.println("Cert Type : " + cert.getType());
					System.out.println("Cert Hash Code : " + cert.hashCode());
					System.out.println("Cert Public Key Algorithm : "
							+ cert.getPublicKey().getAlgorithm());
					System.out.println("Cert Public Key Format : "
							+ cert.getPublicKey().getFormat());
					System.out.println("\n");
				}

			} catch (SSLPeerUnverifiedException e) {
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			}

		}

	}
}
