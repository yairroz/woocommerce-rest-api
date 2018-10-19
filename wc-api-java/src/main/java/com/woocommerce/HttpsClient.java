package com.woocommerce;

import java.io.IOException;
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
     * @param endPointType the type of the request based on enum
     * @return retrieved result
     * @throws IOException when there is a problem with the http connection
     */
    Object get(String url, EndPointBaseType endPointType);

    /**
     * Requests url with HTTP GET and returns List of objects (Maps)
     *
     * @param url URL to request
     * @param requestParams params to request 
     * @param endPointType the type of the request based on enum
     * @return retrieved result
     * @throws IOException when there is a problem with the http connection
     */
    List<?> getAll(String url, Map<String, String> requestParams, EndPointBaseType endPointType);

    /**
     * Requests url with HTTP POST and retrieves result object as Map
     *
     * @param url to request
     * @param endPointType the type of the request based on enum
     * @param object request object with will be sent as json
     * @return retrieved result
     */
    Object post(String url, EndPointBaseType endPointBaseType, Object object);

    /**
     * Requests url with HTTP PUT and retrieves result object as Map
     *
     * @param url    url to request
     * @param endPointType the type of the request based on enum
     * @param object request object with will be sent as json
     * @return retrieved result
     */
    Object put(String url, EndPointBaseType endPointBaseType, Object object);

    /**
     * Requests url with HTTP DELETE and retrieves result object as Map
     *
     * @param url    url to request
     * @param endPointType the type of the request based on enum
     * @return retrieved result
     */
    Object delete(String url, EndPointBaseType endPointBaseType);
}
