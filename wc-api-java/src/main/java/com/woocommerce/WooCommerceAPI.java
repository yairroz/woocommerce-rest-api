package com.woocommerce;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.woocommerce.auth.BasicAuthConfig;
import com.woocommerce.beans.order.WooOrderBatch;

public class WooCommerceAPI implements WooCommerce {

	private static final String API_URL_ENTITY_FORMAT = "%s/wp-json/wc/v1/%s/%d";
	private static final String API_URL_FORMAT = "%s/wp-json/wc/v1/%s";

	private HttpsClient client;
	String baseUrl;

	public WooCommerceAPI(BasicAuthConfig config) throws IOException {
		this.baseUrl = config.getUrl();
		this.client = new DefaultHttpsClient(config);
	}

	@Override
	public Object get(EndPointBaseType endPointType, int id) {
		String url = String.format(API_URL_ENTITY_FORMAT, this.baseUrl, endPointType.getValue(), id);
		return client.get(url, endPointType);
	}

	@Override
	public List<?> getAll(EndPointBaseType endPointType, Map<String, String> requestParams) {
		String url = String.format(API_URL_FORMAT, this.baseUrl, endPointType.getValue());
		return client.getAll(url, requestParams, endPointType);
	}
	
	@Override
	public Object update(EndPointBaseType endPointType, int id, Object object) {
		String url = String.format(API_URL_ENTITY_FORMAT, this.baseUrl, endPointType.getValue(), id);
		return client.put(url, endPointType, object);
	}
	
	@Override
	public Object create(EndPointBaseType endPointType, Object object) {
		String url = String.format(API_URL_FORMAT, this.baseUrl, endPointType.getValue());
		return client.post(url, endPointType, object);
	}
	
	@Override
	public Object delete(EndPointBaseType endPointType, int id) {
		String url = String.format(API_URL_ENTITY_FORMAT, this.baseUrl, endPointType.getValue(), id);
		return client.delete(url, endPointType);
	}
	
	@Override
	public Object batch(EndPointBaseType endPointType, WooOrderBatch wooOrderBatch) {
		String url = String.format(API_URL_FORMAT, this.baseUrl, endPointType.getValue());
		return client.post(url, endPointType, wooOrderBatch);
	}
}
