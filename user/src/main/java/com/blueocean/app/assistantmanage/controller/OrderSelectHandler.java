package com.blueocean.app.assistantmanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.common.utils.RetInfoUtil;
import com.blueocean.common.vo.RetInfo;
import com.blueocean.app.assistantmanage.dto.ValidateUser;
import com.blueocean.app.assistantmanage.service.IOrderSelectService;
import com.blueocean.app.assistantmanage.service.IUserService;
import com.blueocean.app.assistantmanage.web.DrugOrderWeb;
import com.blueocean.common.annotation.SerializedField;
import com.blueocean.app.assistantmanage.dto.DrugOrderDo;


@RestController
@SerializedField(encode=true)
@RequestMapping(value = "DrugOrderAction")
public class OrderSelectHandler {
	@Resource
	private IOrderSelectService iOrderSelectService;
	@Resource
	private IUserService iUserService;
	
	@RequestMapping(value = "reordercount")
	
	public RetInfo reordercount(@RequestBody DrugOrderWeb order){
		ValidateUser checkUser = iUserService.checkUser(order.getSession());
		if(!checkUser.isValidate()){
			RetInfo retInfo=RetInfoUtil.initRetSessionErrTime();
			retInfo.setErrorMsg(checkUser.getMessage());
			return retInfo;
			
		}
		RetInfo retInfo=RetInfoUtil.initRetInfo4SuccTime();
		Integer reordercount=0;
		try {
			reordercount = iOrderSelectService.reordercount(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("orderCount", reordercount);
		retInfo.setData(map);
		return retInfo;
	}
	@RequestMapping(value = "getallorder")
	public RetInfo getallorder(@RequestBody DrugOrderWeb order){
		ValidateUser checkUser = iUserService.checkUser(order.getSession());
		if(!checkUser.isValidate()){
			RetInfo retInfo=RetInfoUtil.initRetSessionErrTime();
			retInfo.setErrorMsg(checkUser.getMessage());
			return retInfo;
		}
		RetInfo retInfo=RetInfoUtil.initRetInfo4SuccTime();
		List<DrugOrderDo> getallorder = iOrderSelectService.getallorder(order);
		
		Map<String, List<DrugOrderDo>> map=new HashMap<String, List<DrugOrderDo>>();
		map.put("orders", getallorder);
		retInfo.setData(map);
		return retInfo;
	}
	@RequestMapping(value = "getallorderbystatus")
	public RetInfo getallorderbystatus(@RequestBody DrugOrderWeb order){
		ValidateUser checkUser = iUserService.checkUser(order.getSession());
		if(!checkUser.isValidate()){
			RetInfo retInfo=RetInfoUtil.initRetSessionErrTime();
			retInfo.setErrorMsg(checkUser.getMessage());
			return retInfo;
		}
		RetInfo retInfo=RetInfoUtil.initRetInfo4SuccTime();
		List<DrugOrderDo> getallorder = iOrderSelectService.getallorder(order);
		retInfo.setData(getallorder);
		return retInfo;
	}
	
}
