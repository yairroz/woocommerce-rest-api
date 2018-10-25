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
import com.woocommerce.beans.common.BillingAddress;
import com.woocommerce.beans.common.Links;
import com.woocommerce.beans.common.ShippingAddress;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"parent_id",
	"status",
	"order_key",
	"number",
	"currency",
	"version",
	"prices_include_tax",
	"date_created",
	"date_modified",
	"customer_id",
	"discount_total",
	"discount_tax",
	"shipping_total",
	"shipping_tax",
	"cart_tax",
	"total",
	"total_tax",
	"billing",
	"shipping",
	"payment_method",
	"payment_method_title",
	"transaction_id",
	"customer_ip_address",
	"customer_user_agent",
	"created_via",
	"customer_note",
	"date_completed",
	"date_paid",
	"cart_hash",
	"line_items",
	"tax_lines",
	"shipping_lines",
	"fee_lines",
	"coupon_lines",
	"refunds",
	"_links"
})
public class WooOrder {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("parent_id")
	private Long parentId;
	@JsonProperty("status")
	private String status;
	@JsonProperty("order_key")
	private String orderKey;
	@JsonProperty("number")
	private Long number;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("version")
	private String version;
	@JsonProperty("prices_include_tax")
	private Boolean pricesIncludeTax;
	@JsonProperty("date_created")
	private String dateCreated;
	@JsonProperty("date_modified")
	private String dateModified;
	@JsonProperty("customer_id")
	private Long customerId;
	@JsonProperty("discount_total")
	private String discountTotal;
	@JsonProperty("discount_tax")
	private String discountTax;
	@JsonProperty("shipping_total")
	private String shippingTotal;
	@JsonProperty("shipping_tax")
	private String shippingTax;
	@JsonProperty("cart_tax")
	private String cartTax;
	@JsonProperty("total")
	private String total;
	@JsonProperty("total_tax")
	private String totalTax;
	@JsonProperty("billing")
	private BillingAddress billing;
	@JsonProperty("shipping")
	private ShippingAddress shipping;
	@JsonProperty("payment_method")
	private String paymentMethod;
	@JsonProperty("payment_method_title")
	private String paymentMethodTitle;
	@JsonProperty("transaction_id")
	private String transactionId;
	@JsonProperty("customer_ip_address")
	private String customerIpAddress;
	@JsonProperty("customer_user_agent")
	private String customerUserAgent;
	@JsonProperty("created_via")
	private String createdVia;
	@JsonProperty("customer_note")
	private String customerNote;
	@JsonProperty("date_completed")
	private String dateCompleted;
	@JsonProperty("date_paid")
	private String datePaid;
	@JsonProperty("cart_hash")
	private String cartHash;
	@JsonProperty("line_items")
	private List<LineItem> lineItems = null;
	@JsonProperty("tax_lines")
	private List<Object> taxLines = null;
	@JsonProperty("shipping_lines")
	private List<ShippingLine> shippingLines = null;
	@JsonProperty("fee_lines")
	private List<Object> feeLines = null;
	@JsonProperty("coupon_lines")
	private List<Object> couponLines = null;
	@JsonProperty("refunds")
	private List<Object> refunds = null;
	@JsonProperty("_links")
	private Links links;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	

	public WooOrder() {}
	
	public WooOrder(Long id, String status) {
		this.id = id;
		this.status = status;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("parent_id")
	public Long getParentId() {
		return parentId;
	}

	@JsonProperty("parent_id")
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("order_key")
	public String getOrderKey() {
		return orderKey;
	}

	@JsonProperty("order_key")
	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	@JsonProperty("number")
	public Long getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(Long number) {
		this.number = number;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("prices_include_tax")
	public Boolean getPricesIncludeTax() {
		return pricesIncludeTax;
	}

	@JsonProperty("prices_include_tax")
	public void setPricesIncludeTax(Boolean pricesIncludeTax) {
		this.pricesIncludeTax = pricesIncludeTax;
	}

	@JsonProperty("date_created")
	public String getDateCreated() {
		return dateCreated;
	}

	@JsonProperty("date_created")
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonProperty("date_modified")
	public String getDateModified() {
		return dateModified;
	}

	@JsonProperty("date_modified")
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	@JsonProperty("customer_id")
	public Long getCustomerId() {
		return customerId;
	}

	@JsonProperty("customer_id")
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@JsonProperty("discount_total")
	public String getDiscountTotal() {
		return discountTotal;
	}

	@JsonProperty("discount_total")
	public void setDiscountTotal(String discountTotal) {
		this.discountTotal = discountTotal;
	}

	@JsonProperty("discount_tax")
	public String getDiscountTax() {
		return discountTax;
	}

	@JsonProperty("discount_tax")
	public void setDiscountTax(String discountTax) {
		this.discountTax = discountTax;
	}

	@JsonProperty("shipping_total")
	public String getShippingTotal() {
		return shippingTotal;
	}

	@JsonProperty("shipping_total")
	public void setShippingTotal(String shippingTotal) {
		this.shippingTotal = shippingTotal;
	}

	@JsonProperty("shipping_tax")
	public String getShippingTax() {
		return shippingTax;
	}

	@JsonProperty("shipping_tax")
	public void setShippingTax(String shippingTax) {
		this.shippingTax = shippingTax;
	}

	@JsonProperty("cart_tax")
	public String getCartTax() {
		return cartTax;
	}

	@JsonProperty("cart_tax")
	public void setCartTax(String cartTax) {
		this.cartTax = cartTax;
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

	@JsonProperty("billing")
	public BillingAddress getBilling() {
		return billing;
	}

	@JsonProperty("billing")
	public void setBilling(BillingAddress billing) {
		this.billing = billing;
	}

	@JsonProperty("shipping")
	public ShippingAddress getShipping() {
		return shipping;
	}

	@JsonProperty("shipping")
	public void setShipping(ShippingAddress shipping) {
		this.shipping = shipping;
	}

	@JsonProperty("payment_method")
	public String getPaymentMethod() {
		return paymentMethod;
	}

	@JsonProperty("payment_method")
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@JsonProperty("payment_method_title")
	public String getPaymentMethodTitle() {
		return paymentMethodTitle;
	}

	@JsonProperty("payment_method_title")
	public void setPaymentMethodTitle(String paymentMethodTitle) {
		this.paymentMethodTitle = paymentMethodTitle;
	}

	@JsonProperty("transaction_id")
	public String getTransactionId() {
		return transactionId;
	}

	@JsonProperty("transaction_id")
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@JsonProperty("customer_ip_address")
	public String getCustomerIpAddress() {
		return customerIpAddress;
	}

	@JsonProperty("customer_ip_address")
	public void setCustomerIpAddress(String customerIpAddress) {
		this.customerIpAddress = customerIpAddress;
	}

	@JsonProperty("customer_user_agent")
	public String getCustomerUserAgent() {
		return customerUserAgent;
	}

	@JsonProperty("customer_user_agent")
	public void setCustomerUserAgent(String customerUserAgent) {
		this.customerUserAgent = customerUserAgent;
	}

	@JsonProperty("created_via")
	public String getCreatedVia() {
		return createdVia;
	}

	@JsonProperty("created_via")
	public void setCreatedVia(String createdVia) {
		this.createdVia = createdVia;
	}

	@JsonProperty("customer_note")
	public String getCustomerNote() {
		return customerNote;
	}

	@JsonProperty("customer_note")
	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}

	@JsonProperty("date_completed")
	public String getDateCompleted() {
		return dateCompleted;
	}

	@JsonProperty("date_completed")
	public void setDateCompleted(String dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	@JsonProperty("date_paid")
	public String getDatePaid() {
		return datePaid;
	}

	@JsonProperty("date_paid")
	public void setDatePaid(String datePaid) {
		this.datePaid = datePaid;
	}

	@JsonProperty("cart_hash")
	public String getCartHash() {
		return cartHash;
	}

	@JsonProperty("cart_hash")
	public void setCartHash(String cartHash) {
		this.cartHash = cartHash;
	}

	@JsonProperty("line_items")
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	@JsonProperty("line_items")
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	@JsonProperty("tax_lines")
	public List<Object> getTaxLines() {
		return taxLines;
	}

	@JsonProperty("tax_lines")
	public void setTaxLines(List<Object> taxLines) {
		this.taxLines = taxLines;
	}

	@JsonProperty("shipping_lines")
	public List<ShippingLine> getShippingLines() {
		return shippingLines;
	}

	@JsonProperty("shipping_lines")
	public void setShippingLines(List<ShippingLine> shippingLines) {
		this.shippingLines = shippingLines;
	}

	@JsonProperty("fee_lines")
	public List<Object> getFeeLines() {
		return feeLines;
	}

	@JsonProperty("fee_lines")
	public void setFeeLines(List<Object> feeLines) {
		this.feeLines = feeLines;
	}

	@JsonProperty("coupon_lines")
	public List<Object> getCouponLines() {
		return couponLines;
	}

	@JsonProperty("coupon_lines")
	public void setCouponLines(List<Object> couponLines) {
		this.couponLines = couponLines;
	}

	@JsonProperty("refunds")
	public List<Object> getRefunds() {
		return refunds;
	}

	@JsonProperty("refunds")
	public void setRefunds(List<Object> refunds) {
		this.refunds = refunds;
	}

	@JsonProperty("_links")
	public Links getLinks() {
		return links;
	}

	@JsonProperty("_links")
	public void setLinks(Links links) {
		this.links = links;
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