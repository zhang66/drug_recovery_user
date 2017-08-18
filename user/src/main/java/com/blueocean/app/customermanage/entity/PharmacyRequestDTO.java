package com.blueocean.app.customermanage.entity;

public class PharmacyRequestDTO {

	private String id;

	private String siteName;

	private Integer pharmacyStatus;
	// 查询附近回收点
	private String lng;// 经度
	private String lat;// 纬度
	//修改密码
	private String oldPassword;
	private String newPassword;
	// 每页条数(默认10)
	private int PageSize = 10;
	// 页数(默认1)
	private int page = 1;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getPharmacyStatus() {
		return pharmacyStatus;
	}

	public void setPharmacyStatus(Integer pharmacyStatus) {
		this.pharmacyStatus = pharmacyStatus;
	}

	@Override
	public String toString() {
		return "PharmacyRequestDTO [id=" + id + ", siteName=" + siteName + ", PharmacyStatus=" + pharmacyStatus
				+ ", PageSize=" + PageSize + ", PageIndex=" + page + "]";
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

}
