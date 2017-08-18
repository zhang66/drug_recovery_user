package com.blueocean.app.assistantmanage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.common.vo.ResultJson;
import com.blueocean.app.assistantmanage.dto.DrugInfoDto;
import com.blueocean.app.assistantmanage.dto.DrugOrderInfoDto;
import com.blueocean.app.assistantmanage.dto.DrugOrderOperationDto;
import com.blueocean.app.assistantmanage.dto.MatchOrderDto;
import com.blueocean.app.assistantmanage.dto.ValidateUser;
import com.blueocean.app.assistantmanage.service.DrugOrderOperationService;
import com.blueocean.app.assistantmanage.service.IUserService;
import com.blueocean.common.constant.RetInfoConstant;
import com.blueocean.common.annotation.SerializedField;

/**
 * 订单操作接口
 * @author wuyanli
 *
 */
@RestController
@SerializedField(encode=true)//json加密
@RequestMapping("DrugOrderAction")
public class DrugOrderOpterationHandler {
	@Resource
	private DrugOrderOperationService orderService;
	@Resource
	private IUserService iUserService;
	
	/**
	 * 关闭订单接口
	 * @param map
	 * @return
	 */
//	@isNotDecrypt//json不进行解密
	@RequestMapping("closeDrugOrder")
	public ResultJson closeDrugOrder(@RequestBody Map<String,String> map){
		//验证session
		ValidateUser checkUser = iUserService.checkUser(map.get("session"));
		if(!checkUser.isValidate()){
			return ResultJson.get(1003).addErrorMsg(checkUser.getMessage()).addAcceptTime(RetInfoConstant.acceptTime);
		}
		int closeOrder = orderService.closeOrder(map.get("userId"),map.get("orderId"));
		if(closeOrder <= 0){
			return ResultJson.get(1001).addErrorMsg("error").addAcceptTime(RetInfoConstant.acceptTime);
		}
		return ResultJson.get(0).addErrorMsg("success").addAcceptTime(RetInfoConstant.acceptTime);
	}
	
	/**
	 * 根据订单号获取已完成订单详情接口
	 * @param map
	 * @return
	 */
//	@isNotDecrypt//json不进行解密
	@RequestMapping("getFinishedOrderInfo")
	public ResultJson getFinishedOrderInfo(@RequestBody Map<String,String> map){
		ValidateUser checkUser = iUserService.checkUser(map.get("session"));
		if(!checkUser.isValidate()){
			return ResultJson.get(1003).addErrorMsg(checkUser.getMessage()).addAcceptTime(RetInfoConstant.acceptTime);
		}
		DrugOrderInfoDto finishOrderInfo = orderService.getFinishOrderInfo(map.get("orderId"));
		if(finishOrderInfo == null){
			return ResultJson.get(1001).addErrorMsg("error").addAcceptTime(RetInfoConstant.acceptTime).addData("");
		}
		return ResultJson.get(0).addErrorMsg("success").addAcceptTime(RetInfoConstant.acceptTime).addData(finishOrderInfo);
	}
	
	
	/**
	 * 查询药品信息接口
	 * @param map
	 * @return
	 */
//	@isNotDecrypt//json不进行解密
	@RequestMapping("getDrugInfo")
	public ResultJson getDrugInfo(@RequestBody Map<String,String> map){
		ValidateUser checkUser = iUserService.checkUser(map.get("session"));
		if(!checkUser.isValidate()){
			return ResultJson.get(1003).addErrorMsg(checkUser.getMessage()).addAcceptTime(RetInfoConstant.acceptTime);
		}
		String upc = map.get("upc");
//		System.out.println(upc+"----");
		if(upc.isEmpty()){
			return ResultJson.get(1001).addErrorMsg("error").addAcceptTime(RetInfoConstant.acceptTime).addData("");
		}
		DrugInfoDto drupInfo = orderService.getDrupInfo(upc);
		if(drupInfo == null){
			return ResultJson.get(1005).addErrorMsg("暂无该药品信息！").addAcceptTime(RetInfoConstant.acceptTime).addData(null);
		}
		return ResultJson.get(0).addErrorMsg("success").addAcceptTime(RetInfoConstant.acceptTime).addData(drupInfo);
	}
	
	/**
	 * 匹配订单接口
	 * @return
	 */
//	@isNotDecrypt//json不进行解密
	@RequestMapping("orderMatch")
	public ResultJson orderMatch(@RequestBody MatchOrderDto matchOrder){
		ValidateUser checkUser = iUserService.checkUser(matchOrder.getSession());
		if(!checkUser.isValidate()){
			return ResultJson.get(1003).addErrorMsg(checkUser.getMessage()).addAcceptTime(RetInfoConstant.acceptTime);
		}
		Map<String, Object> orderMatchInfo = orderService.orderMatchInfo(matchOrder);
		System.out.println("orderMatchInfo:"+orderMatchInfo);
		if("-1".equals(orderMatchInfo.get("sta"))){
			return ResultJson.get(1001).addErrorMsg("error").addAcceptTime(RetInfoConstant.acceptTime).addData("");
		}
		Map<String,Object> data = new HashMap<>();
		data.put("orderId", orderMatchInfo.get("orderId"));
		return ResultJson.get(0).addErrorMsg("success").addAcceptTime(RetInfoConstant.acceptTime).addData(data);
	}
	
	/**
	 * 添加新订单接口
	 * @param order
	 * @return
	 */
//	@isNotDecrypt//json不进行解密
	@RequestMapping("addNewOrder")
	public ResultJson addNewOrder(@RequestBody DrugOrderOperationDto order){
		ValidateUser checkUser = iUserService.checkUser(order.getSession());
		if(!checkUser.isValidate()){
			return ResultJson.get(1003).addErrorMsg(checkUser.getMessage()).addAcceptTime(RetInfoConstant.acceptTime);
		}
		System.out.println(order);
		Map<String, Object> map = orderService.addNewOrder(order);
		System.out.println("map:"+map);
		if("-1".equals(map.get("sta"))){
			return ResultJson.get(1001).addErrorMsg("error").addAcceptTime(RetInfoConstant.acceptTime).addData("");
		}
		Map<String,Object> data = new HashMap<>();
		data.put("orderId", map.get("orderId"));
		return ResultJson.get(0).addErrorMsg("success").addAcceptTime(RetInfoConstant.acceptTime).addData(data);
	}

}
