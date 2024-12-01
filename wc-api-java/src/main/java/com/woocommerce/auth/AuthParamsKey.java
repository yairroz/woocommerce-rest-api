package com.woocommerce.auth;

public enum AuthParamsKey {

	CONSUMER_KEY("consumer_key"),
	CONSUMER_SECRET("consumer_secret");
	
	private final String value;
	
	AuthParamsKey(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
