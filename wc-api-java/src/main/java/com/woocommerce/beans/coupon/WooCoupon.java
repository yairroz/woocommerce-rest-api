
package com.woocommerce.beans.coupon;

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
import com.woocommerce.beans.common.Links;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "code",
    "date_created",
    "date_modified",
    "discount_type",
    "description",
    "amount",
    "expiry_date",
    "usage_count",
    "individual_use",
    "product_ids",
    "exclude_product_ids",
    "usage_limit",
    "usage_limit_per_user",
    "limit_usage_to_x_items",
    "free_shipping",
    "product_categories",
    "excluded_product_categories",
    "exclude_sale_items",
    "minimum_amount",
    "maximum_amount",
    "email_restrictions",
    "used_by",
    "_links"
})
public class WooCoupon {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("code")
    private String code;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_modified")
    private String dateModified;
    @JsonProperty("discount_type")
    private String discountType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("expiry_date")
    private String expiryDate;
    @JsonProperty("usage_count")
    private Long usageCount;
    @JsonProperty("individual_use")
    private Boolean individualUse;
    @JsonProperty("product_ids")
    private List<Object> productIds = null;
    @JsonProperty("exclude_product_ids")
    private List<Object> excludeProductIds = null;
    @JsonProperty("usage_limit")
    private Object usageLimit;
    @JsonProperty("usage_limit_per_user")
    private Object usageLimitPerUser;
    @JsonProperty("limit_usage_to_x_items")
    private Long limitUsageToXItems;
    @JsonProperty("free_shipping")
    private Boolean freeShipping;
    @JsonProperty("product_categories")
    private List<Long> productCategories = null;
    @JsonProperty("excluded_product_categories")
    private List<Object> excludedProductCategories = null;
    @JsonProperty("exclude_sale_items")
    private Boolean excludeSaleItems;
    @JsonProperty("minimum_amount")
    private String minimumAmount;
    @JsonProperty("maximum_amount")
    private String maximumAmount;
    @JsonProperty("email_restrictions")
    private List<Object> emailRestrictions = null;
    @JsonProperty("used_by")
    private List<Object> usedBy = null;
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

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
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

    @JsonProperty("discount_type")
    public String getDiscountType() {
        return discountType;
    }

    @JsonProperty("discount_type")
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("expiry_date")
    public String getExpiryDate() {
        return expiryDate;
    }

    @JsonProperty("expiry_date")
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @JsonProperty("usage_count")
    public Long getUsageCount() {
        return usageCount;
    }

    @JsonProperty("usage_count")
    public void setUsageCount(Long usageCount) {
        this.usageCount = usageCount;
    }

    @JsonProperty("individual_use")
    public Boolean getIndividualUse() {
        return individualUse;
    }

    @JsonProperty("individual_use")
    public void setIndividualUse(Boolean individualUse) {
        this.individualUse = individualUse;
    }

    @JsonProperty("product_ids")
    public List<Object> getProductIds() {
        return productIds;
    }

    @JsonProperty("product_ids")
    public void setProductIds(List<Object> productIds) {
        this.productIds = productIds;
    }

    @JsonProperty("exclude_product_ids")
    public List<Object> getExcludeProductIds() {
        return excludeProductIds;
    }

    @JsonProperty("exclude_product_ids")
    public void setExcludeProductIds(List<Object> excludeProductIds) {
        this.excludeProductIds = excludeProductIds;
    }

    @JsonProperty("usage_limit")
    public Object getUsageLimit() {
        return usageLimit;
    }

    @JsonProperty("usage_limit")
    public void setUsageLimit(Object usageLimit) {
        this.usageLimit = usageLimit;
    }

    @JsonProperty("usage_limit_per_user")
    public Object getUsageLimitPerUser() {
        return usageLimitPerUser;
    }

    @JsonProperty("usage_limit_per_user")
    public void setUsageLimitPerUser(Object usageLimitPerUser) {
        this.usageLimitPerUser = usageLimitPerUser;
    }

    @JsonProperty("limit_usage_to_x_items")
    public Long getLimitUsageToXItems() {
        return limitUsageToXItems;
    }

    @JsonProperty("limit_usage_to_x_items")
    public void setLimitUsageToXItems(Long limitUsageToXItems) {
        this.limitUsageToXItems = limitUsageToXItems;
    }

    @JsonProperty("free_shipping")
    public Boolean getFreeShipping() {
        return freeShipping;
    }

    @JsonProperty("free_shipping")
    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    @JsonProperty("product_categories")
    public List<Long> getProductCategories() {
        return productCategories;
    }

    @JsonProperty("product_categories")
    public void setProductCategories(List<Long> productCategories) {
        this.productCategories = productCategories;
    }

    @JsonProperty("excluded_product_categories")
    public List<Object> getExcludedProductCategories() {
        return excludedProductCategories;
    }

    @JsonProperty("excluded_product_categories")
    public void setExcludedProductCategories(List<Object> excludedProductCategories) {
        this.excludedProductCategories = excludedProductCategories;
    }

    @JsonProperty("exclude_sale_items")
    public Boolean getExcludeSaleItems() {
        return excludeSaleItems;
    }

    @JsonProperty("exclude_sale_items")
    public void setExcludeSaleItems(Boolean excludeSaleItems) {
        this.excludeSaleItems = excludeSaleItems;
    }

    @JsonProperty("minimum_amount")
    public String getMinimumAmount() {
        return minimumAmount;
    }

    @JsonProperty("minimum_amount")
    public void setMinimumAmount(String minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    @JsonProperty("maximum_amount")
    public String getMaximumAmount() {
        return maximumAmount;
    }

    @JsonProperty("maximum_amount")
    public void setMaximumAmount(String maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    @JsonProperty("email_restrictions")
    public List<Object> getEmailRestrictions() {
        return emailRestrictions;
    }

    @JsonProperty("email_restrictions")
    public void setEmailRestrictions(List<Object> emailRestrictions) {
        this.emailRestrictions = emailRestrictions;
    }

    @JsonProperty("used_by")
    public List<Object> getUsedBy() {
        return usedBy;
    }

    @JsonProperty("used_by")
    public void setUsedBy(List<Object> usedBy) {
        this.usedBy = usedBy;
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
