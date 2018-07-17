package com.woocommerce;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Main interface for WooCommerce REST API
 */
public interface WooCommerce {

    /**
     * Creates WooCommerce entity
     *
     * @param endpointBase API endpoint base @see EndpointBaseType
     * @param object       Map with entity properties and values
     * @return Map with created entity
     */
//    Map create(String endpointBase, Map<String, Object> object);

    /**
     * Retrieves on WooCommerce entity
     *
     * @param endpointBaseType API endpoint base @see EndpointBaseType
     * @param id id of WooCommerce entity
     * @return Retrieved WooCommerce entity
     * @throws IOException when there is a problem with the http connection
     */
    Object get(EndpointBaseType endpointBaseType, int id) throws IOException;

    /**
     * Retrieves all WooCommerce entities
     *
     * @param endpointBaseType API endpoint base @see EndpointBaseType
     * @param params API Map (key=OrderParamsKeys, value=String) of params that will concatenate to the request, @see OrderParamsKeys
     * @return List of retrieved entities
     * @throws IOException when there is a problem with the http connection
     */
    List getAll(EndpointBaseType endpointBaseType, Map params) throws IOException;

    /**
     * Updates WooCommerce entity
     *
     * @param endpointBase API endpoint base @see EndpointBaseType
     * @param id           id of the entity to update
     * @param object       Map with updated properties
     * @return updated WooCommerce entity
     */
//    Map update(String endpointBase, int id, Map<String, Object> object);

    /**
     * Deletes WooCommerce entity
     *
     * @param endpointBase API endpoint base @see EndpointBaseType
     * @param id           id of the entity to update
     * @return deleted WooCommerce entity
     */
//    Map delete(String endpointBase, int id);

}
