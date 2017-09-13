# WooCommerce API Java Wrapper
Java wrapper for WooCommerce REST API. Currently the library supports only latest version of WooCommerce REST API (v1)
with the OAuth 1.0a authentication over the HTTPS protocol.

## Setup
wc-api-java is available on maven central:
```xml
will update soon
```

## Usage

```java
    public static void main(String[] args) {
        // Set path and password to yours trustStore 
        // (you need to make sure that you have the relevant certificate in the trusStore)
        // I suggest to use the next tool to create yours trusStore and to save on him the relevant certificate for your woocommerce:
        // http://keystore-explorer.org/
		System.setProperty("javax.net.ssl.trustStore", "C:/Users/<user>/<.keystore>");
		System.setProperty("javax.net.ssl.trustStorePassword", "<password>");        
        
      // Setup client
      BasicAuthConfig basicAuthConfig = new BasicAuthConfig("http://woocommerce.com", "consumerKey", "consumerSecret");
      WooCommerceAPI wooCommerceAPI = new WooCommerceAPI(basicAuthConfig);
		
		// Prepare object for request
		HashMap<OrderParamsKeys, String> params = new HashMap<>();
		params.put(OrderParamsKeys.PER_PAGE , "30");

		// Make request and retrieve result		
		List<WooOrder> orders = (List<WooOrder>)wooCommerceAPI.getAll(EndpointBaseType.ORDERS, params);
		
		// Print the results
		int i = 1;
		for (WooOrder order : orders) {
			System.out.println("Index: " + i++ + "  ====");
			System.out.println("Id: " + order.getId());
			System.out.println("TotaL: " + order.getTotal());
			System.out.println("status:" + order.getStatus());
			System.out.println("CreatedVia: " + order.getCreatedVia());
			System.out.println("DateCompleted: " + order.getDateCompleted());
			System.out.println("City: " + order.getShipping().getCity());
			System.out.println(order.getCustomerUserAgent());
			System.out.println();
		}

		// Another example
		System.out.println("==============================================");
		WooOrder order = (WooOrder)wooCommerceAPI.get(EndpointBaseType.ORDERS, 31350);
		System.out.println("Id: " + order.getId());
		System.out.println("TotaL: " + order.getTotal());
		System.out.println("status:" + order.getStatus());
		System.out.println("CreatedVia: " + order.getCreatedVia());
		System.out.println("DateCompleted: " + order.getDateCompleted());
		System.out.println("City: " + order.getShipping().getCity());
		System.out.println(order.getCustomerUserAgent());
		System.out.println();
	}
```
