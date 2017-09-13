package com.woocommerce.beans.common;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
	"self",
	"collection"
})
public class Links {

	@JsonProperty("self")
	private List<Self> self = null;
	@JsonProperty("collection")
	private List<Collection> collection = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("self")
	public List<Self> getSelf() {
		return self;
	}

	@JsonProperty("self")
	public void setSelf(List<Self> self) {
		this.self = self;
	}

	@JsonProperty("collection")
	public List<Collection> getCollection() {
		return collection;
	}

	@JsonProperty("collection")
	public void setCollection(List<Collection> collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
