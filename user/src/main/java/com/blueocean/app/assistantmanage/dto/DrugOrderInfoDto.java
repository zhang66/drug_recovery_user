package com.blueocean.app.assistantmanage.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.blueocean.common.utils.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 订单信息详情表
 * @author wuyanli
 *
 */
public class DrugOrderInfoDto implements Serializable {
   
    private String orderId;

    private String orderStatus;

    private String orderType;

    private Integer userId;

    private String orderPhone;

    private String orderAddr;
    
    private Double cashCoupon;
   
    private Date orderTime;//创建订单时间
    
    private Date orderCompleteTime;
    
    private Date closeOrderTime;
    
    private List<DrugInfoDto> drugInfos;
    
    private static final long serialVersionUID = 1L;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public Double getCashCoupon() {
		return cashCoupon;
	}

	public void setCashCoupon(Double cashCoupon) {
		this.cashCoupon = cashCoupon;
	}


	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getOrderCompleteTime() {
		return orderCompleteTime;
	}

	public void setOrderCompleteTime(Date orderCompleteTime) {
		this.orderCompleteTime = orderCompleteTime;
	}
	//传回的时间 yyyy:MM:dd hh:mm
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getCloseOrderTime() {
		return closeOrderTime;
	}

	public void setCloseOrderTime(Date closeOrderTime) {
		this.closeOrderTime = closeOrderTime;
	}

	public List<DrugInfoDto> getDrugInfos() {
		return drugInfos;
	}

	public void setDrugInfos(List<DrugInfoDto> drugInfos) {
		this.drugInfos = drugInfos;
	}

	@Override
	public String toString() {
		return "DrugOrderInfoDto [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderType=" + orderType
				+ ", userId=" + userId + ", orderPhone=" + orderPhone + ", orderAddr=" + orderAddr + ", cashCoupon="
				+ cashCoupon + ", orderTime=" + orderTime + ", orderCompleteTime=" + orderCompleteTime
				+ ", closeOrderTime=" + closeOrderTime + ", drugInfos=" + drugInfos + "]";
	}


}