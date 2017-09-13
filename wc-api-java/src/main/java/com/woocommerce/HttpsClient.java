package com.woocommerce;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Basic interface for HTTP client
 */
public interface HttpsClient {

    /**
     * Requests url with HTTP GET and returns result object as Map
     *
     * @param url URL to request
     * @param endpointBaseType the type of the request based on enum
     * @return retrieved result
     * @throws IOException when there is a problem with the http connection
     */
    Object get(URL url, EndpointBaseType endpointBaseType) throws IOException;

    /**
     * Requests url with HTTP GET and returns List of objects (Maps)
     *
     * @param url URL to request
     * @param endpointBaseType the type of the request based on enum
     * @return retrieved result
     * @throws IOException when there is a problem with the http connection
     */
    List getAll(URL url, EndpointBaseType endpointBaseType) throws IOException;

    /**
     * Requests url with HTTP POST and retrieves result object as Map
     *
     * @param url to request
     * @param params to request
     * @param object request object with will be sent as json
     * @return retrieved result
     */
    Map post(String url, Map<String, String> params, Map<String, Object> object);

    /**
     * Requests url with HTTP PUT and retrieves result object as Map
     *
     * @param url    url to request
     * @param params request params
     * @param object request object with will be sent as json
     * @return retrieved result
     */
    Map put(String url, Map<String, String> params, Map<String, Object> object);

    /**
     * Requests url with HTTP DELETE and retrieves result object as Map
     *
     * @param url    url to request
     * @param params request params
     * @return retrieved result
     */
    Map delete(String url, Map<String, String> params);
}
