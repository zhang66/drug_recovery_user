package com.blueocean.app.customermanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.blueocean.common.constant.PharmacyConstant;
import com.blueocean.app.customermanage.dao.DrugOrderDao;
import com.blueocean.app.customermanage.dao.DrugRecycleSiteDao;
import com.blueocean.app.customermanage.dto.DrugRecycleSiteDo;
import com.blueocean.app.customermanage.entity.PharmacyRequestDTO;
import com.blueocean.app.customermanage.entity.PharmacyResponseDTO;
import com.blueocean.app.customermanage.entity.SiteInRangeDTO;
import com.blueocean.app.customermanage.service.PharmacyManageInfo;

@Service
public class PharmacyManageImpl implements PharmacyManageInfo {

	@Resource
	private DrugRecycleSiteDao drugRecycleSiteDoMapper;
	@Resource
	private DrugOrderDao drugOrderDoMapper;

	@Override
	public PharmacyResponseDTO getDrugRecycleInfo(Integer id) {
		DrugRecycleSiteDo drs = drugRecycleSiteDoMapper.selectByPrimaryKey(id);
		if (null == drs) {
			throw new RuntimeException("该药店不存在!");
		}
		DrugRecycleSiteDo sitedo = drugRecycleSiteDoMapper.selectByPrimaryKey(id);
		PharmacyResponseDTO sitedto = new PharmacyResponseDTO();
		BeanUtils.copyProperties(sitedo, sitedto);
		sitedto.setSiteType(String.valueOf(sitedo.getSiteType()));
		sitedto.setSiteTypeName(PharmacyConstant.SiteTypeName(sitedo.getSiteType()));
		return sitedto;
	}

	@Override
	public List<SiteInRangeDTO> listPharmacyInRange(PharmacyRequestDTO record) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("lng", record.getLng());
		params.put("lat", record.getLat());
		List<SiteInRangeDTO> list = drugRecycleSiteDoMapper.listPharmacyInRange(params);
		return list;
	}


	/**
	 * 账户是否存在校验
	 */
	@Override
	public boolean selectExistAccount(String account) {
		List<DrugRecycleSiteDo> list = drugRecycleSiteDoMapper.selectExistAccount(account);
		boolean res = list == null || list.size() == 0 ? false : true;
		return res;
	}

	@Override
	public int changeSitePassword(PharmacyRequestDTO record) {
		DrugRecycleSiteDo drs = drugRecycleSiteDoMapper.selectByPrimaryKey(Integer.valueOf(record.getId()));
		if (null == drs) {
			throw new RuntimeException("该用户不存在!");
		}
		if (!drs.getPassword().equals(record.getOldPassword())) {
			throw new RuntimeException("旧密码输入错误!");
		}
		DrugRecycleSiteDo drug = new DrugRecycleSiteDo();
		drug.setId(Integer.valueOf(record.getId()));
		drug.setPassword(record.getNewPassword());
		return drugRecycleSiteDoMapper.updateByPrimaryKeySelective(drug);
	}



}
