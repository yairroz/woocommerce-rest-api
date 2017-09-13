package com.woocommerce.integration;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.woocommerce.EndpointBaseType;
import com.woocommerce.WooCommerce;
import com.woocommerce.WooCommerceAPI;
import com.woocommerce.auth.BasicAuthConfig;
import com.woocommerce.beans.order.OrderParamsKeys;
import com.woocommerce.beans.order.WooOrder;
import com.woocommerce.beans.product.WooProduct;

public class WooCommerceClientTest {

    private static final String WC_HTTPS_URL = "https://www.rozenfeld.co.il/";
    private static final String CONSUMER_KEY = "ck_7169889e4eb6d6c93e5d76759e7835d0e3b3e8d1";
    private static final String CONSUMER_SECRET = "cs_5776d8b7c066387945f296d84f159b4191e821d0";

    private WooCommerce wooCommerce;

    @Before
    public void setUp() throws IOException {
    	BasicAuthConfig basicAuthConfig = new BasicAuthConfig(WC_HTTPS_URL, CONSUMER_KEY, CONSUMER_SECRET);
		wooCommerce = new WooCommerceAPI(basicAuthConfig);
    }

//    @Ignore
//    @Test
//    public void apiCreateProductTest() {
//        Map<String, Object> productInfo = new HashMap<>();
//        productInfo.put("name", "Premium Quality");
//        productInfo.put("type", "simple");
//        productInfo.put("regular_price", "21.99");
//        productInfo.put("description", "Pellentesque habitant morbi tristique senectus et netus");
//        Map product = wooCommerce.create(EndpointBaseType.PRODUCTS.getValue(), productInfo);
//        Assert.assertNotNull(product);
//    }

    @Ignore
    @Test
    public void apiGetAllProductsTest() throws IOException {
        @SuppressWarnings("unchecked")
		List<WooProduct> all = wooCommerce.getAll(EndpointBaseType.PRODUCTS, new HashMap<OrderParamsKeys, String>());
        Assert.assertNotNull(all);
    }
    
    @Ignore
    @Test
    public void apiGetAllOrders30PerPageTest() throws IOException {
    	HashMap<OrderParamsKeys, String> params = new HashMap<>();
		params.put(OrderParamsKeys.PER_PAGE , "30");
    	@SuppressWarnings("unchecked")
		List<WooOrder> all = wooCommerce.getAll(EndpointBaseType.ORDERS, params);
        Assert.assertNotNull(all);
    }

    @Ignore
    @Test
    public void apiGetProductTest() throws IOException {
        WooProduct product = (WooProduct) wooCommerce.get(EndpointBaseType.PRODUCTS, 10);
        Assert.assertNotNull(product);
    }

//    @Ignore
//    @Test
//    public void apiUpdateProductTest() {
//        Map<String, Object> productInfo = new HashMap<>();
//        productInfo.put("name", "Premium Quality UPDATED");
//        Map product = wooCommerce.update(EndpointBaseType.PRODUCTS.getValue(), 10, productInfo);
//        Assert.assertNotNull(product);
//    }

//    @Ignore
//    @Test
//    public void apiDeleteProductTest() {
//        Map product = wooCommerce.delete(EndpointBaseType.PRODUCTS.getValue(), 10);
//        Assert.assertNotNull(product);
//    }
}
