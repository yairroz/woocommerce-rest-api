package com.woocommerce.beans.order;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"create",
	"update",
	"delete"})

public class WooOrderBatch {

	public WooOrderBatch() {
		this.createList = new ArrayList<>();
		this.updateList = new ArrayList<>();
		this.deleteList = new ArrayList<>();
	}

	@JsonProperty("create")
	private List<WooOrder> createList;
	@JsonProperty("update")
	private List<WooOrder> updateList;
	@JsonProperty("delete")
	private List<WooOrder> deleteList;
	
	@JsonProperty("create")
	public List<WooOrder> getCreateList() {
		return createList;
	}

//	@JsonProperty("create")
//	public void setCreateList(List<WooOrder> createList) {
//		this.createList = createList;
//	}
	
	@JsonProperty("update")
	public List<WooOrder> getUpdateListt() {
		return updateList;
	}

//	@JsonProperty("update")
//	public void setUpdateList(List<WooOrder> updateList) {
//		this.updateList = updateList;
//	}
	
	@JsonProperty("delete")
	public List<WooOrder> getDeleteList() {
		return deleteList;
	}

//	@JsonProperty("delete")
//	public void setDeleteList(List<WooOrder> deleteList) {
//		this.deleteList = deleteList;
//	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
