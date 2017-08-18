package com.blueocean.app.customermanage.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.app.customermanage.dto.DrugOrderDo;
import com.blueocean.app.customermanage.entity.PharmacyResponseDTO;
import com.blueocean.app.customermanage.service.DrugOrderInfo;
import com.blueocean.app.customermanage.service.PharmacyManageInfo;
import com.blueocean.common.annotation.isNotDecrypt;
import com.blueocean.common.util.RetInfoUtil;
import com.blueocean.common.vo.RetInfo;




@RequestMapping(value = "DrugOrderAction")
@RestController
public class DrugOrderController {

	@Resource
	private DrugOrderInfo drugOrderInfo;
	@Resource
	private PharmacyManageInfo pharmacyManageInfo;

	/**
	 * @author zhangyalin
	 * 
	 * @return
	 */
	@isNotDecrypt
	@RequestMapping(value = "addOrder")
	public RetInfo addOrder(@RequestBody DrugOrderDo record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		drugOrderInfo.addOrder(record);
		// ��ȡ���յ�����
		PharmacyResponseDTO data = pharmacyManageInfo.getDrugRecycleInfo(record.getDrugRecycleSiteId());
		if (data != null) {
			String msg=String.format("%s %s", data.getSiteName(),
					data.getContactPhone());
			ret.setData(msg);
		} 
		return ret;
	}

	/**
	 * @author zhangyalin 
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateOrder")
	public RetInfo updateOrder(@RequestBody DrugOrderDo record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		drugOrderInfo.updateOrder(record);
		return ret;

	}

}
