package com.blueocean.app.assistantmanage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.blueocean.app.assistantmanage.dto.DrugInfoDto;

@Mapper
public interface DrugInfoDao {
	
	/**
	 * 药品信息查询
	 * @param map
	 * @return 药品信息
	 */
	DrugInfoDto getDrugInfoByUpc(String upc);

}
