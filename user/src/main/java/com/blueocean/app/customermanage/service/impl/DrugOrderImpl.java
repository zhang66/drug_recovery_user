package com.blueocean.app.customermanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blueocean.app.assistantmanage.service.IUserService;
import com.blueocean.app.customermanage.dao.DrugOrderDao;
import com.blueocean.app.customermanage.dao.DrugRecycleSiteDao;
import com.blueocean.app.customermanage.dto.DrugOrderDo;
import com.blueocean.app.customermanage.dto.DrugRecycleSiteDo;
import com.blueocean.app.customermanage.service.DrugOrderInfo;
import com.blueocean.common.constant.OrderConstant.OrderStatus;
import com.blueocean.common.constant.OrderConstant.OrderType;
import com.blueocean.common.util.StringUtil;
import com.blueocean.common.util.UUIDGen;
import com.blueocean.common.utils.MessageUtils;
import com.blueocean.common.utils.SendMessageUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @author 王欣宇
 * @time 2017年7月26日 上午10:01:19
 * @todo
 * @remark
 */
@Service
public class DrugOrderImpl implements DrugOrderInfo {

	@Resource
	private DrugOrderDao drugOrderDoMapper;
	@Resource
	private IUserService userService;
	@Resource
	private DrugRecycleSiteDao drugRecycleSiteDoMapper;

	@Override
	public int addOrder(DrugOrderDo record) {
	
		record.setOrderId(UUIDGen.getNumID());
		record.setUserId(record.getDrugRecycleSiteId());
		record.setOrderStatus(String.valueOf(OrderStatus.WaitRecovere));
		if(String.valueOf(OrderType.SelfSend).equals(record.getOrderType())){//自送地址为空
			record.setOrderAddr(null);
		}
		int res = drugOrderDoMapper.insertSelective(record);
		// 下单成功给店员推送消息
		String cid = userService.selectCidByUid(record.getDrugRecycleSiteId());
		if (!StringUtil.isNull(cid)) {
			try {
				SendMessageUtils.send(cid, "下单提示", "您有新的待回收订单，请及时处理");
			}
			catch (Exception ex) {
			}
		}
		DrugRecycleSiteDo sitedo = drugRecycleSiteDoMapper.selectByPrimaryKey(record.getDrugRecycleSiteId());
		//用户订单成功 给用户发送短信通知--单线程，短信发送失败不影响事务
		try {
			Thread t = new Thread(new Runnable() {
				public void run() {
					String msg;
					if(record.getOrderType().equals(OrderType.Deliver)){//上门
					msg=String.format("您已成功预约了药回收-s%（s%）上门取药服务，工作人员将于24小时内与您取得联系。",record.getDrugRecycleSiteName(),sitedo.getContactPhone());
					}else{//自送
					msg=String.format("您已成功预约了药回收-s%（s%）送到店服务，请您在7日内将待回收药品送至指定药店。",record.getDrugRecycleSiteName(),sitedo.getContactPhone());}
				MessageUtils.sendMessage(msg,record.getOrderPhone());
				}
			});
			t.start();
		} catch (Exception e2) {e2.printStackTrace();}
		return res;
	}


	@Override
	public int updateOrder(DrugOrderDo record) {
		DrugOrderDo order = selectOrderById(record.getOrderId());
		if (null == order) {
			throw new RuntimeException("该订单不存在!");
		}
		return drugOrderDoMapper.updateByPrimaryKeySelective(record);
	}


	@Override
	public DrugOrderDo selectOrderById(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
}
