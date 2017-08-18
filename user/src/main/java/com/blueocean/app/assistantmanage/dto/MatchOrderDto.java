package com.blueocean.app.assistantmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.blueocean.app.assistantmanage.entity.OrderDrugRelationDo;

public class MatchOrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String session;

	private String orderId;
	
	private String userId;
	
	private Double cashCoupon;
	
	private String orderPhone;
	
	private Integer orderStatus;
	
    private Integer recycleCount;
	
	private List<OrderDrugRelationDo> drugInfos;

	
	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getCashCoupon() {
		return cashCoupon;
	}

	public void setCashCoupon(Double cashCoupon) {
		this.cashCoupon = cashCoupon;
	}

	
	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	

	public Integer getRecycleCount() {
		return recycleCount;
	}

	public void setRecycleCount(Integer recycleCount) {
		this.recycleCount = recycleCount;
	}

	public List<OrderDrugRelationDo> getDrugInfos() {
		return drugInfos;
	}

	public void setDrugInfos(List<OrderDrugRelationDo> drugInfos) {
		this.drugInfos = drugInfos;
	}

	@Override
	public String toString() {
		return "MatchOrderDto [session=" + session + ", orderId=" + orderId + ", userId=" + userId + ", cashCoupon="
				+ cashCoupon + ", orderPhone=" + orderPhone + ", orderStatus=" + orderStatus + ", recycleCount="
				+ recycleCount + ", drugInfos=" + drugInfos + "]";
	}

}
