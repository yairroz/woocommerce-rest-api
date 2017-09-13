
package com.woocommerce.beans.customer;

import java.util.HashMap;
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
    "date_created",
    "date_modified",
    "email",
    "first_name",
    "last_name",
    "username",
    "last_order",
    "orders_count",
    "total_spent",
    "avatar_url",
    "billing",
    "shipping",
    "_links"
})
public class WooCustomer {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_modified")
    private Object dateModified;
    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private Object lastName;
    @JsonProperty("username")
    private String username;
    @JsonProperty("last_order")
    private LastOrder lastOrder;
    @JsonProperty("orders_count")
    private Long ordersCount;
    @JsonProperty("total_spent")
    private String totalSpent;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("billing")
    private BillingAddress billing;
    @JsonProperty("shipping")
    private ShippingAddress shipping;
    @JsonProperty("_links")
    private Links links;
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

    @JsonProperty("date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("date_created")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("date_modified")
    public Object getDateModified() {
        return dateModified;
    }

    @JsonProperty("date_modified")
    public void setDateModified(Object dateModified) {
        this.dateModified = dateModified;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public Object getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("last_order")
    public LastOrder getLastOrder() {
        return lastOrder;
    }

    @JsonProperty("last_order")
    public void setLastOrder(LastOrder lastOrder) {
        this.lastOrder = lastOrder;
    }

    @JsonProperty("orders_count")
    public Long getOrdersCount() {
        return ordersCount;
    }

    @JsonProperty("orders_count")
    public void setOrdersCount(Long ordersCount) {
        this.ordersCount = ordersCount;
    }

    @JsonProperty("total_spent")
    public String getTotalSpent() {
        return totalSpent;
    }

    @JsonProperty("total_spent")
    public void setTotalSpent(String totalSpent) {
        this.totalSpent = totalSpent;
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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
