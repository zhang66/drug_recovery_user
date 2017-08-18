package com.blueocean.app.assistantmanage.dto;

import java.io.Serializable;
import java.util.List;
import com.blueocean.app.assistantmanage.entity.OrderDrugRelationDo;

public class DrugOrderOperationDto implements Serializable {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String session;

	private String orderId;
  
    private Integer orderType;
    
    private Integer orderStatus;

    private Integer userId;

    private String orderAddr;
   
    private String orderPhone;

    private Double cashCoupon;
    
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

	public Integer getRecycleCount() {
		return recycleCount;
	}

	public void setRecycleCount(Integer recycleCount) {
		this.recycleCount = recycleCount;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public Double getCashCoupon() {
		return cashCoupon;
	}

	public void setCashCoupon(Double cashCoupon) {
		this.cashCoupon = cashCoupon;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public List<OrderDrugRelationDo> getDrugInfos() {
		return drugInfos;
	}

	public void setDrugInfos(List<OrderDrugRelationDo> drugInfos) {
		this.drugInfos = drugInfos;
	}

	@Override
	public String toString() {
		return "DrugOrderOperationDto [orderId=" + orderId + ", orderType=" + orderType + ", orderStatus=" + orderStatus
				+ ", userId=" + userId + ", orderAddr=" + orderAddr + ", orderPhone=" + orderPhone + ", cashCoupon="
				+ cashCoupon + ", recycleCount=" + recycleCount + ", drugInfos=" + drugInfos + "]";
	}

}