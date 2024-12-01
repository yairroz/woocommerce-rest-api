package com.woocommerce.integration;


import com.woocommerce.EndPointBaseType;
import com.woocommerce.WooCommerce;
import com.woocommerce.WooCommerceAPI;
import com.woocommerce.auth.BasicAuthConfig;
import com.woocommerce.beans.order.WooOrder;
import com.woocommerce.beans.product.WooProduct;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WooCommerceClientTest {

    private static final String WC_HTTPS_URL = "http://woocommerce.com";
    private static final String CONSUMER_KEY = "consumerKey";
    private static final String CONSUMER_SECRET = "consumerSecret";
    private static final int ORDER_ID = 1019296; // change this to a valid order id
    private WooCommerce wooCommerce;

    @Before
    public void setUp() {
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
    public void apiGetAllProductsTest() {
        @SuppressWarnings("unchecked")
		    List<WooProduct> all = (List<WooProduct>) wooCommerce.getAll(EndPointBaseType.PRODUCTS, new HashMap<>());
        Assert.assertNotNull(all);
    }
    
    @Ignore
    @Test
    public void apiGetAllOrders30PerPageTest() {
    	HashMap<String, String> params = new HashMap<>();
//		  params.put(OrderParamsKeys.PER_PAGE.getValue() , "3");
    	@SuppressWarnings("unchecked")
		  List<WooOrder> all = (List<WooOrder>) wooCommerce.getAll(EndPointBaseType.ORDERS, params);
      Assert.assertNotNull(all);
      for (WooOrder wooOrder : all) {
        System.out.println(wooOrder);
      }
      System.out.println("SIZE: " + all.size());
    }

    @Ignore
    @Test
    public void apiGetByIdTest() {
      WooOrder order = (WooOrder) wooCommerce.get(EndPointBaseType.ORDERS, ORDER_ID);
      Assert.assertNotNull(order);
      System.out.println(order);
    }

    @Ignore
    @Test
    public void apiGetProductTest() {
        WooProduct product = (WooProduct) wooCommerce.get(EndPointBaseType.PRODUCTS, 10);
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
