package com.woocommerce.beans.order;

public enum OrderParamsValues {
	
	VIEW("view", OrderParamsKeys.CONTEXT),
	EDIT("edit", OrderParamsKeys.CONTEXT),
	ASC("asc", OrderParamsKeys.ORDER),
	DESC("desc", OrderParamsKeys.ORDER),
	DATE("date", OrderParamsKeys.ORDER_BY),
	ID("id", OrderParamsKeys.ORDER_BY),
	INCLUDE("include", OrderParamsKeys.ORDER_BY),
	TITLE("title", OrderParamsKeys.ORDER_BY),
	SLUG("slug", OrderParamsKeys.ORDER_BY),
	ANY("any", OrderParamsKeys.STATUS),
	PENDING("pending", OrderParamsKeys.STATUS),
	PROCESSING("processing", OrderParamsKeys.STATUS),
	ON_HOLD("on-hold", OrderParamsKeys.STATUS),
	COMPLETED("completed", OrderParamsKeys.STATUS), 
	CANCELLED("cancelled", OrderParamsKeys.STATUS),
	REFUNDED("refunded", OrderParamsKeys.STATUS),
	FAILED("failed", OrderParamsKeys.STATUS);
	
	private String value;
	private OrderParamsKeys relevantKey;
	
	
	private OrderParamsValues(String value, OrderParamsKeys relevantKey){
		this.value = value;
		this.relevantKey = relevantKey;
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @return the relevantKey
	 */
	public OrderParamsKeys getRelevantKey() {
		return relevantKey;
	}
}
