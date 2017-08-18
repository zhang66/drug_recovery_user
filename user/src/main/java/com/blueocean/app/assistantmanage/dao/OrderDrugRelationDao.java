package com.blueocean.app.assistantmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.blueocean.app.assistantmanage.dto.DrugInfoDto;
import com.blueocean.app.assistantmanage.entity.OrderDrugRelationDo;
@Mapper
public interface OrderDrugRelationDao {
	/**
	 * 
	 * @param relation
	 * @return
	 */
	int insertBatchRelation(@Param("list")List<OrderDrugRelationDo> list);

	/**
	 * 通过订单编号 获取该订单编号下的药品详情
	 * @param orderId
	 * @return
	 */
	List<DrugInfoDto> getDrugInfosByOrderId(String orderId);
}
