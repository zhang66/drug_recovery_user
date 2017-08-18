package com.blueocean.app.assistantmanage.entity;

import java.io.Serializable;

/**
 * 订单药品管理表
 * @author wuyanli
 *
 */
public class OrderDrugRelationDo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String drugId;
	
	private String orderId;
	
	private Integer drugCount;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public Integer getDrugCount() {
		return drugCount;
	}

	public void setDrugCount(Integer drugCount) {
		this.drugCount = drugCount;
	}

	@Override
	public String toString() {
		return "OrderDrugRelationDo [id=" + id + ", drugId=" + drugId + ", orderId=" + orderId + ", drugCount="
				+ drugCount + "]";
	}


}
