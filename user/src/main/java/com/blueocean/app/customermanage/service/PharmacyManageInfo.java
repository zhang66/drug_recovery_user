package com.blueocean.app.customermanage.service;

import java.util.List;


import com.blueocean.app.customermanage.entity.PharmacyRequestDTO;
import com.blueocean.app.customermanage.entity.PharmacyResponseDTO;
import com.blueocean.app.customermanage.entity.SiteInRangeDTO;

public interface PharmacyManageInfo {


	/**
	 * 根据id查订单详情
	 * 
	 * @param id
	 * @return
	 */
	PharmacyResponseDTO getDrugRecycleInfo(Integer id);
	/**
	 * 查询account是否存在
	 * 
	 * @param account
	 * @return
	 */
	boolean selectExistAccount(String account);

	/**
	 * 修改回收点账户密码
	 * 
	 * @param record
	 * @return
	 */
	int changeSitePassword(PharmacyRequestDTO record);

	/**
	 * 根据经纬度查询药店列表
	 * 
	 * @param record
	 * @return
	 */
	List<SiteInRangeDTO> listPharmacyInRange(PharmacyRequestDTO record);


}
