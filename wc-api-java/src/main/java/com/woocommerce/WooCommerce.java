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
     * @param endPointType API endPoint base @see EndpointBaseType
     * @param object       Map with entity properties and values
     * @return Map with created entity
     */
    Object create(EndPointBaseType endpointBase, Object object);

    /**
     * Retrieves on WooCommerce entity
     *
     * @param endPointType API endPoint base @see EndpointBaseType
     * @param id id of WooCommerce entity
     * @return Retrieved WooCommerce entity
     * @throws IOException when there is a problem with the http connection
     */
    Object get(EndPointBaseType endPointType, int id);

    /**
     * Retrieves all WooCommerce entities
     *
     * @param endPointType API endPoint base @see EndpointBaseType
     * @param params API Map (key=OrderParamsKeys, value=String) of params that will concatenate to the request, @see OrderParamsKeys
     * @return List of retrieved entities
     * @throws IOException when there is a problem with the http connection
     */
	List<?> getAll(EndPointBaseType endPointType, Map<String, String> params);

    /**
     * Updates WooCommerce entity
     *
     * @param endPointType API endPoint base @see EndpointBaseType
     * @param id           id of the entity to update
     * @param object       Map with updated properties
     * @return updated WooCommerce entity
     */
    Object update(EndPointBaseType endPointType, int id, Object object);

    /**
     * Deletes WooCommerce entity
     *
     * @param endPointType API endPoint base @see EndpointBaseType
     * @param id           id of the entity to update
     * @return deleted WooCommerce entity
     */
    Object delete(EndPointBaseType endPointType, int id);

}
