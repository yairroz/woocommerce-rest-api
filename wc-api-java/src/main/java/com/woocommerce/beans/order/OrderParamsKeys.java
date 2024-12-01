package com.woocommerce.beans.order;

/**
 * Enum of woocommerce orders params query.
 * according to WooCommerce Rest API documentation.
 * URL: <a><a href="http://woocommerce.github.io/woocommerce-rest-api-docs/#list-all-orders">...</a></a>
 */
public enum OrderParamsKeys {

	/**
	 * Scope under which the request is made; determines fields present in response
	 * The value of this key is String.
	 * The value options is:  view and edit.
	 * Default value is view.
	 */
	CONTEXT("context"),
	
	/**
	 * Current page of the collection.
	 * The value of this key is integer.
	 * Default value is 1
	 */
	PAGE("page"),
	
	/**
	 * Maximum number of items to be returned in result set.
	 * The value of this key is integer.
	 * Default value is 10.  
	 */
	PER_PAGE("per_page"),
	
	/**
	 * Limit results to those matching a string.
	 * The value of this key is String.
	 */
	SEARCH("search"),
	
	/**
	 * Limit response to resources published after a given ISO8601 compliant date.
	 * The value of this key is String.
	 */
	AFTER("after"),
	
	/**
	 * Limit response to resources published before a given ISO8601 compliant date.
	 * The value of this key is String.
	 */
	BEFORE("before"),
	
	/**
	 * Ensure result set excludes specific IDs.
	 * The value of this key is Array.
	 */
	EXCLUDE("exclude"),
	
	/**
	 * Limit result set to specific ids.
	 * The value of this key is Array.
	 */
	INCLUDE("include"),
	
	/**
	 * Offset the result set by a specific number of items.
	 * The value of this key is integer.
	 */
	OFFSET("offset"),
	
	/**
	 * Order sort attribute ascending or descending.
	 * The value of this key is String.
	 * The value options is: asc(ascending) and desc(descending).
	 * The default value is desc.  
	 */
	ORDER("order"),
	
	/**
	 * Sort collection by object attribute.
	 * The value of this key is String.
	 * The value options is: date, id, include, title and slug.
	 * The default value is date.
	 */
	ORDER_BY("orderby"),
	
	/**
	 * Limit result set to those of particular parent IDs.
	 * The value of this key is Array.
	 */
	PARENT("parent"),
	
	/**
	 * Limit result set to all items except those of a particular parent ID.
	 * The value of this key is Array.
	 */
	PARENT_EXCLUDE("parent_exclude"),
	
	/**
	 * Limit result set to orders assigned a specific status.
	 * The value of this key is String.
	 * The value options is: any, pending, processing, on-hold, completed, cancelled, refunded and failed.
	 * The default value is any.  
	 */
	STATUS("status"),
	
	/**
	 * Limit result set to orders assigned a specific customer.
	 * The value of this key is integer.
	 */
	CUSTOMER("customer"),
	
	/**
	 * Limit result set to orders assigned a specific product.
	 * The value of this key is integer.
	 */
	PRODUCT("product"),
	
	/**
	 * Number of decimal points to use in each resource.
	 * The value of this key is integer.
	 * The default value is 2.
	 */
	DP("dp");
	
	
	private final String value;
	
	OrderParamsKeys(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
