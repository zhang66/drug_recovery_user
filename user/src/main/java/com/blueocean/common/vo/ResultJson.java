package com.blueocean.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(value=JsonInclude.Include.NON_NULL)
public class ResultJson {
	private int errorCode;
	private Integer count;
	private Object errorMsg;
	private Object data;
	private String acceptTime;
	
	private ResultJson(int status) {
		this.errorCode = status;
	}
	
	public static ResultJson get(int status) {
		return new ResultJson(status);
	}
	public ResultJson addErrorMsg(Object message) {
		this.errorMsg = message;
		return this;
	}
	public ResultJson addData(Object data) {
		this.data = data;
		return this;
	}
	public ResultJson addAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
		return this;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public Object getErrorMsg() {
		return errorMsg;
	}

	public String getAcceptTime() {
		return acceptTime;
	}

	public void setErrorCode(int status) {
		this.errorCode = status;
	}
	public Object getData() {
		return data;
	}

	public Integer getCount() {
		return count;
	}

	public ResultJson setCount(Integer count) {
		this.count = count;
		return this;
	}

}
