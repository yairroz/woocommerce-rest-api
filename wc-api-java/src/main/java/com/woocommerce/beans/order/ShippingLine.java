package com.woocommerce.beans.order;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"method_title",
	"method_id",
	"total",
	"total_tax",
	"taxes"
})
public class ShippingLine {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("method_title")
	private String methodTitle;
	@JsonProperty("method_id")
	private String methodId;
	@JsonProperty("total")
	private String total;
	@JsonProperty("total_tax")
	private String totalTax;
	@JsonProperty("taxes")
	private List<Object> taxes = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("method_title")
	public String getMethodTitle() {
		return methodTitle;
	}

	@JsonProperty("method_title")
	public void setMethodTitle(String methodTitle) {
		this.methodTitle = methodTitle;
	}

	@JsonProperty("method_id")
	public String getMethodId() {
		return methodId;
	}

	@JsonProperty("method_id")
	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	@JsonProperty("total")
	public String getTotal() {
		return total;
	}

	@JsonProperty("total")
	public void setTotal(String total) {
		this.total = total;
	}

	@JsonProperty("total_tax")
	public String getTotalTax() {
		return totalTax;
	}

	@JsonProperty("total_tax")
	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}

	@JsonProperty("taxes")
	public List<Object> getTaxes() {
		return taxes;
	}

	@JsonProperty("taxes")
	public void setTaxes(List<Object> taxes) {
		this.taxes = taxes;
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