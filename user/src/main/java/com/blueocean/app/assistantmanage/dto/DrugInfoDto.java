package com.blueocean.app.assistantmanage.dto;

import java.io.Serializable;

public class DrugInfoDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String drugName;
	
	private Integer drugCount;
	
	private String drugId;
	
	private String drugPic;
	
	public Integer getDrugCount() {
		return drugCount;
	}

	public void setDrugCount(Integer drugCount) {
		this.drugCount = drugCount;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	
	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugPic() {
		return drugPic;
	}

	public void setDrugPic(String drugPic) {
		this.drugPic = drugPic;
	}

	@Override
	public String toString() {
		return "DrugInfoDto [drugName=" + drugName + ", drugCount=" + drugCount + ", drugId=" + drugId + ", drugPic="
				+ drugPic + "]";
	}

}
