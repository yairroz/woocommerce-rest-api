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
	"name",
	"sku",
	"product_id",
	"variation_id",
	"quantity",
	"tax_class",
	"price",
	"subtotal",
	"subtotal_tax",
	"total",
	"total_tax",
	"taxes",
	"meta"
})
public class LineItem {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("sku")
	private String sku;
	@JsonProperty("product_id")
	private Long productId;
	@JsonProperty("variation_id")
	private Long variationId;
	@JsonProperty("quantity")
	private Long quantity;
	@JsonProperty("tax_class")
	private String taxClass;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("subtotal")
	private Double subtotal;
	@JsonProperty("subtotal_tax")
	private Double subtotalTax;
	@JsonProperty("total")
	private Double total;
	@JsonProperty("total_tax")
	private Double totalTax;
	@JsonProperty("taxes")
	private List<Object> taxes = null;
	@JsonProperty("meta")
	private List<Object> meta = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("sku")
	public String getSku() {
		return sku;
	}

	@JsonProperty("sku")
	public void setSku(String sku) {
		this.sku = sku;
	}

	@JsonProperty("product_id")
	public Long getProductId() {
		return productId;
	}

	@JsonProperty("product_id")
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@JsonProperty("variation_id")
	public Long getVariationId() {
		return variationId;
	}

	@JsonProperty("variation_id")
	public void setVariationId(Long variationId) {
		this.variationId = variationId;
	}

	@JsonProperty("quantity")
	public Long getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("tax_class")
	public String getTaxClass() {
		return taxClass;
	}

	@JsonProperty("tax_class")
	public void setTaxClass(String taxClass) {
		this.taxClass = taxClass;
	}

	@JsonProperty("price")
	public Double getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonProperty("subtotal")
	public Double getSubtotal() {
		return subtotal;
	}

	@JsonProperty("subtotal")
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	@JsonProperty("subtotal_tax")
	public Double getSubtotalTax() {
		return subtotalTax;
	}

	@JsonProperty("subtotal_tax")
	public void setSubtotalTax(Double subtotalTax) {
		this.subtotalTax = subtotalTax;
	}

	@JsonProperty("total")
	public Double getTotal() {
		return total;
	}

	@JsonProperty("total")
	public void setTotal(Double total) {
		this.total = total;
	}

	@JsonProperty("total_tax")
	public Double getTotalTax() {
		return totalTax;
	}

	@JsonProperty("total_tax")
	public void setTotalTax(Double totalTax) {
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

	@JsonProperty("meta")
	public List<Object> getMeta() {
		return meta;
	}

	@JsonProperty("meta")
	public void setMeta(List<Object> meta) {
		this.meta = meta;
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
