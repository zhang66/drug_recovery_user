package com.blueocean.app.customermanage.entity;

import com.blueocean.common.util.StringUtil;

public class SiteInRangeDTO {

	private Integer id;
	private String name;
	private String fullAddress;
	private String distance;
	private String lng;// 经度
	private String lat;// 纬度
	private PositionDTO position;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getDistance() {
		return StringUtil.isNullOrEmpty(distance) ? distance : distance + "米";
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public PositionDTO getPosition() {
		position = new PositionDTO();
		position.setLat(this.lat);
		position.setLng(this.lng);
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
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
