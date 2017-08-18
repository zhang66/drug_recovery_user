package com.blueocean.app.customermanage.service;

import java.util.List;

import com.blueocean.app.customermanage.dto.DrugOrderDo;


public interface DrugOrderInfo {


	/**
	 * 用戶订单录入
	 * 
	 * @param record
	 * @return
	 */
	int addOrder(DrugOrderDo record);

	/**
	 * 根据订单id查询订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	DrugOrderDo selectOrderById(String orderId);

	/**
	 * 根据订单id修改订单信息
	 * 
	 * @param record
	 * @return
	 */
	int updateOrder(DrugOrderDo record);

}
