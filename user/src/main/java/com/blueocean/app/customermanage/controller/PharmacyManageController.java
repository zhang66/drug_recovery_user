package com.blueocean.app.customermanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.app.assistantmanage.service.IUserService;
import com.blueocean.app.customermanage.dto.DrugRecycleSiteDo;
import com.blueocean.app.customermanage.entity.PharmacyRequestDTO;
import com.blueocean.app.customermanage.entity.SiteInRangeDTO;
import com.blueocean.app.customermanage.service.PharmacyManageInfo;
import com.blueocean.common.annotation.SerializedField;
import com.blueocean.common.annotation.isNotDecrypt;
import com.blueocean.common.utils.RetInfoUtil;
import com.blueocean.common.vo.RetInfo;


/**
 * 
 * @className com.bluesea.drugmanage.controller.DrugManageController.java
 * @author wangxinyu
 * @time 2017��7��12�� ����4:49:42
 * @todo TODO
 */
@SerializedField(encode=false)
@RequestMapping(value = "PharmacyManageAction")
@RestController
public class PharmacyManageController {
	@Resource
	private PharmacyManageInfo pharmacyManageInfo;
	
	@Resource
	private IUserService userService;

	/**
	 * @author zhangyalin ����˻������Ƿ��Ѵ���
	 * 
	 * @return
	 */
	@RequestMapping(value = "checkExistAccount")
	public RetInfo checkExistAccount(@RequestBody DrugRecycleSiteDo record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		boolean res = pharmacyManageInfo.selectExistAccount(record.getAccount());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isExist", res);
		ret.setData(map);
		return ret;
	}

	/**
	 * @author zhangyalin �޸Ļ��յ��˻�����
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "changeSitePassword")
	public RetInfo changeSitePassword(@RequestBody PharmacyRequestDTO record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		int res = pharmacyManageInfo.changeSitePassword(record);
		if (res <= 0)
			ret = RetInfoUtil.initRetInfo4Err();
		return ret;
	}

	/**
	 * 
	 * @author zhangyalin
	 * @time 2017��7��25�� ����5:23:04
	 * @params PharmacyRequestDTO
	 * @todo ���ݾ�γ�Ȳ�ѯҩ���б�
	 */
	@isNotDecrypt
	@RequestMapping(value = "listSiteInRange")
	public RetInfo listSiteInRange(@RequestBody PharmacyRequestDTO record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		List<SiteInRangeDTO> PharmacyLst = pharmacyManageInfo.listPharmacyInRange(record);
		ret.setData(PharmacyLst);
		return ret;

	}

}
