package com.blueocean.app.assistantmanage.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueocean.common.utils.MessageUtils;
import com.blueocean.common.utils.UUIDGen;
import com.blueocean.app.assistantmanage.dao.DrugInfoDao;
import com.blueocean.app.assistantmanage.dao.DrugOrderOpterationDao;
import com.blueocean.app.assistantmanage.dao.OrderDrugRelationDao;
import com.blueocean.app.assistantmanage.dto.DrugInfoDto;
import com.blueocean.app.assistantmanage.dto.DrugOrderInfoDto;
import com.blueocean.app.assistantmanage.dto.DrugOrderOperationDto;
import com.blueocean.app.assistantmanage.dto.MatchOrderDto;
import com.blueocean.app.assistantmanage.entity.OrderDrugRelationDo;
import com.blueocean.app.assistantmanage.service.DrugOrderOperationService;
import com.blueocean.common.constant.OrderConstant;

@Service
public class DrugOrderOperationServiceImpl implements DrugOrderOperationService {
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	@Autowired
	private DrugOrderOpterationDao drugOrderDao;
	
	@Autowired
	private OrderDrugRelationDao relationDao;
	
	@Autowired
	private DrugInfoDao drugInfoDao;

	/**
	 * 关闭订单
	 */
	@Override
	public int closeOrder(String userId, String orderId) {
		
		Map<String,String> map = new HashMap<>();
		//订单Id
		map.put("orderId", orderId);
		//订单状态
		map.put("orderStatus", OrderConstant.OrderStatus.Closed+"");
		//关闭订单时间
		map.put("closeOrderTime",  format.format(new Date()));
		int updateByOrderId = drugOrderDao.updateByOrderId(map);
		return updateByOrderId;
		
	}

	/**
	 * 根据订单号查询已完成订单详情
	 */
	@Override
	public DrugOrderInfoDto getFinishOrderInfo(String orderId) {
//		System.out.println("orderId:"+orderId);
		DrugOrderInfoDto drugOrderInfo = drugOrderDao.getDrugOrderInfo(orderId);
		List<DrugInfoDto> drugInfoList = relationDao.getDrugInfosByOrderId(orderId);
		drugOrderInfo.setDrugInfos(drugInfoList);
		return drugOrderInfo;
	}

	/**
	 * 药品信息查询
	 */
	@Override
	public DrugInfoDto getDrupInfo(String upc) {
//		System.out.println("upc:"+upc);
		return drugInfoDao.getDrugInfoByUpc(upc);
	}


	/**
	 * 匹配订单 
	 */
	@Override
	public Map<String,Object> orderMatchInfo(MatchOrderDto matchOrder) {
		//更新订单表中的信息
//		System.out.println("===="+matchOrder);
		List<OrderDrugRelationDo> relationList = matchOrder.getDrugInfos();
		Map<String, Object> map = new HashMap<>();
		String orderId = matchOrder.getOrderId();
		//回收总数量
		int recycleCount = 0;
		for(int i = 0;i<relationList.size();i++){
			relationList.get(i).setId(UUIDGen.getRandomString(18));
			relationList.get(i).setOrderId(orderId);
			recycleCount += relationList.get(i).getDrugCount();
		}
		matchOrder.setRecycleCount(recycleCount);
		matchOrder.setOrderStatus(OrderConstant.OrderStatus.Finished);
		int matchOrderByOrderId = drugOrderDao.updateOrderByOrderId(matchOrder);
		//对订单药品关联表进行插入批量操作
		int insertBatchRelation = relationDao.insertBatchRelation(relationList);
		if(matchOrderByOrderId>0 && insertBatchRelation>0){
			map.put("sta", "1");
			//订单成功 给用户发送短信通知优惠券金额
			//单线程，短信发送失败不影响事务
			/*try {
				Thread t = new Thread(new Runnable() {
					public void run() {
					MessageUtils.sendMessage("",matchOrder.getOrderPhone());
					}
				});
				t.start();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}*/
			
		}else{
			map.put("sta", "-1");
		}
		map.put("orderId", orderId);
		return map;
	}
	
	/**
	 * 添加新订单
	 * 
	 * 先添加订单
	 * 获取订单编号
	 * 更新订单表回收数量
	 */
	@Override
	public Map<String,Object> addNewOrder(DrugOrderOperationDto order) {
		int recycleCount = 0;
		Map<String, Object> map = new HashMap<>();
		//订单编号
		String orderId = UUIDGen.getNumID();
		
		order.setOrderId(orderId);
		order.setOrderType(OrderConstant.OrderType.SelfSend);
		order.setOrderStatus(OrderConstant.OrderStatus.Finished);
		List<OrderDrugRelationDo> relationList = order.getDrugInfos();
		for(int i = 0;i<relationList.size();i++){
			relationList.get(i).setId(UUIDGen.getRandomString(18));
			relationList.get(i).setOrderId(orderId);
			recycleCount += relationList.get(i).getDrugCount();
		}
		order.setRecycleCount(recycleCount);
		int insertNewOrder = drugOrderDao.insertNewOrder(order);
		//添加新订单
		//对订单药品关联表进行插入批量操作
//		System.out.println("========="+relationList);
		int insertBatchRelation = relationDao.insertBatchRelation(relationList);
		if(insertNewOrder>0 && insertBatchRelation>0){
			map.put("sta", "1");
			//订单成功 给用户发送短信通知优惠券金额
			//单线程，短信发送失败不影响事务
			/*try {
				Thread t = new Thread(new Runnable() {
					public void run() {
					MessageUtils.sendMessage("",order.getOrderPhone());
					}
				});
				t.start();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}*/
		}else{
			map.put("sta", "-1");
		}
		map.put("orderId", orderId);
		return map;
	}

}
