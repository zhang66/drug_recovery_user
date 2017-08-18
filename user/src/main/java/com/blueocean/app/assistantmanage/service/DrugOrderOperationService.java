package com.blueocean.app.assistantmanage.service;

import java.util.Map;

import com.blueocean.app.assistantmanage.dto.DrugInfoDto;
import com.blueocean.app.assistantmanage.dto.DrugOrderInfoDto;
import com.blueocean.app.assistantmanage.dto.DrugOrderOperationDto;
import com.blueocean.app.assistantmanage.dto.MatchOrderDto;

/**
 * 订单操作
 * @author wuyanli
 *
 */
public interface DrugOrderOperationService {
	/**
	 * 关闭订单
	 * @return 
	 */
	int closeOrder(String userId,String orderId);
	
	
	/**
	 * 已完成订单查看订单详情
	 * @return 已完成订单信息
	 */
	DrugOrderInfoDto getFinishOrderInfo(String orderId);
	
	/**
	 * 药品信息查询
	 * @return
	 */
	DrugInfoDto getDrupInfo(String upc);
	
	
	/**
	 * 更新订单状态与优惠券金额（匹配订单确定更改订单状态为已完成）
	 * @return
	 */
	Map<String,Object> orderMatchInfo(MatchOrderDto matchOrder);
	
	
	/**
	 * 生成新订单
	 * @return
	 */
	Map<String,Object> addNewOrder(DrugOrderOperationDto order);

}
