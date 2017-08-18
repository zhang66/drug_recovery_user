package com.blueocean.app.assistantmanage.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blueocean.app.assistantmanage.dao.DrugOrderSelectDao;
import com.blueocean.app.assistantmanage.service.IOrderSelectService;
import com.blueocean.app.assistantmanage.web.DrugOrderWeb;
import com.blueocean.common.constant.OrderConstant;
import com.blueocean.common.util.StringUtil;
import com.blueocean.app.assistantmanage.dto.DrugOrderDo;
@Service
public class OrderSelectServiceImpl implements IOrderSelectService{
	@Resource
	private DrugOrderSelectDao drugOrderSelectDoMapper;
	public Integer reordercount(DrugOrderWeb order){
		order.setOrderStatus(OrderConstant.OrderStatus.WaitRecovere+"");
		Integer count = drugOrderSelectDoMapper.selectCountByUserId(order);
		return count;
		
	}
	@Override
	public List<DrugOrderDo> getallorder(DrugOrderWeb order) {
		String orderId = order.getOrderId();
		
		if(StringUtil.empty(orderId)){
			List<DrugOrderDo> selectAllOrder = drugOrderSelectDoMapper.selectAllOrder(order);
			return selectAllOrder;
		}else {
			DrugOrderDo last = drugOrderSelectDoMapper.selectByPrimaryKey(orderId);
			if (last!=null) {
				Date orderTime = last.getOrderTime();
				order.setOrderTime(orderTime);
				List<DrugOrderDo> selectAllOrder = drugOrderSelectDoMapper.selectAllOrder(order);
				return selectAllOrder;
			}else{
				return null;
			}
		}
		
	}
	
	
}
