package com.blueocean.app.assistantmanage.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.blueocean.app.assistantmanage.dto.DrugOrderInfoDto;
import com.blueocean.app.assistantmanage.dto.DrugOrderOperationDto;
import com.blueocean.app.assistantmanage.dto.MatchOrderDto;
/**
 * 药品订单操作
 * @author wuyanli
 *
 */
@Mapper
public interface DrugOrderOpterationDao {
	/**
	 * 根据orderId更新订单表中的数据 
	 * @param map
	 * @return
	 */
	int updateByOrderId(Map<String,String> map);
	
	/**
	 * 根据订单号查询订单详情
	 * @param userId
	 * @param drugId
	 * @return
	 */
	DrugOrderInfoDto getDrugOrderInfo(@Param("orderId")String orderId);
	
	
	/**
	 * 匹配订单 
	 * @return
	 */
	int updateOrderByOrderId(MatchOrderDto matchOrder);
	
	/**
	 * 生成新订单
	 * @param order
	 * @return
	 */
	int insertNewOrder(DrugOrderOperationDto order);
	

}
