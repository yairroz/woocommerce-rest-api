package com.woocommerce;

import java.util.List;
import java.util.Map;

import com.woocommerce.beans.order.WooOrderBatch;

/**
 * Main interface for WooCommerce REST API
 */
public interface WooCommerce {

    /**
     * Creates WooCommerce entity
     *
     * @param endPointBaseType API endPoint base @see {@link EndPointBaseType}
     * @param object       Map with entity properties and values
     * @return Map with created entity
     */
    Object create(EndPointBaseType endPointBaseType, Object object);

    /**
     * Retrieves on WooCommerce entity
     *
     * @param endPointBaseType API endPoint base @see {@link EndPointBaseType}
     * @param id id of WooCommerce entity
     * @return Retrieved WooCommerce entity
     */
    Object get(EndPointBaseType endPointBaseType, int id);

    /**
     * Retrieves all WooCommerce entities
     *
     * @param endPointBaseType API endPoint base @see {@link EndPointBaseType}
     * @param params API Map (key=OrderParamsKeys, value=String) of params that will concatenate to the request, @see OrderParamsKeys
     * @return List of retrieved entities
     */
	List<?> getAll(EndPointBaseType endPointBaseType, Map<String, String> params);

    /**
     * Updates WooCommerce entity
     *
     * @param endPointBaseType API endPoint base @see {@link EndPointBaseType}
     * @param id           id of the entity to update
     * @param object       Map with updated properties
     * @return updated WooCommerce entity
     */
    Object update(EndPointBaseType endPointBaseType, int id, Object object);

    /**
     * Deletes WooCommerce entity
     *
     * @param endPointBaseType API endPoint base @see {@link EndPointBaseType}
     * @param id           id of the entity to update
     * @return deleted WooCommerce entity
     */
    Object delete(EndPointBaseType endPointBaseType, int id);
    
    /**
     * Create\Update\Delete batch of WooCommerce entity
     *
     * @param endPointBaseType API endPoint base @see {@link EndPointBaseType}
     * @param wooOrderBatch entity properties and values @see {@link WooOrderBatch}
     * @return Object with created entity
     */
    Object batch(EndPointBaseType endPointBaseType, WooOrderBatch wooOrderBatch);

}
