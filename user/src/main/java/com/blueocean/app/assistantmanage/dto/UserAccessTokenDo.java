package com.blueocean.app.assistantmanage.dto;

import java.io.Serializable;
import java.util.Date;

public class UserAccessTokenDo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column useraccesstoken.TokenId
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private Long tokenid;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column useraccesstoken.UserId
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column useraccesstoken.Sessionkey
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private String sessionkey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column useraccesstoken.TimeOut
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private Date timeout;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column useraccesstoken.LastAccessTime
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private Date lastaccesstime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column useraccesstoken.LastAccessKey
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private String lastaccesskey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column useraccesstoken.MachineCode
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private String machinecode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column useraccesstoken.CreateDateTime
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private Date createdatetime;
    private String cid;


	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table useraccesstoken
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column useraccesstoken.TokenId
     *
     * @return the value of useraccesstoken.TokenId
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public Long getTokenid() {
        return tokenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column useraccesstoken.TokenId
     *
     * @param tokenid the value for useraccesstoken.TokenId
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public void setTokenid(Long tokenid) {
        this.tokenid = tokenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column useraccesstoken.UserId
     *
     * @return the value of useraccesstoken.UserId
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column useraccesstoken.UserId
     *
     * @param userid the value for useraccesstoken.UserId
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column useraccesstoken.Sessionkey
     *
     * @return the value of useraccesstoken.Sessionkey
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public String getSessionkey() {
        return sessionkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column useraccesstoken.Sessionkey
     *
     * @param sessionkey the value for useraccesstoken.Sessionkey
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey == null ? null : sessionkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column useraccesstoken.TimeOut
     *
     * @return the value of useraccesstoken.TimeOut
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public Date getTimeout() {
        return timeout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column useraccesstoken.TimeOut
     *
     * @param timeout the value for useraccesstoken.TimeOut
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public void setTimeout(Date timeout) {
        this.timeout = timeout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column useraccesstoken.LastAccessTime
     *
     * @return the value of useraccesstoken.LastAccessTime
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public Date getLastaccesstime() {
        return lastaccesstime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column useraccesstoken.LastAccessTime
     *
     * @param lastaccesstime the value for useraccesstoken.LastAccessTime
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public void setLastaccesstime(Date lastaccesstime) {
        this.lastaccesstime = lastaccesstime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column useraccesstoken.LastAccessKey
     *
     * @return the value of useraccesstoken.LastAccessKey
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public String getLastaccesskey() {
        return lastaccesskey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column useraccesstoken.LastAccessKey
     *
     * @param lastaccesskey the value for useraccesstoken.LastAccessKey
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public void setLastaccesskey(String lastaccesskey) {
        this.lastaccesskey = lastaccesskey == null ? null : lastaccesskey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column useraccesstoken.MachineCode
     *
     * @return the value of useraccesstoken.MachineCode
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public String getMachinecode() {
        return machinecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column useraccesstoken.MachineCode
     *
     * @param machinecode the value for useraccesstoken.MachineCode
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public void setMachinecode(String machinecode) {
        this.machinecode = machinecode == null ? null : machinecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column useraccesstoken.CreateDateTime
     *
     * @return the value of useraccesstoken.CreateDateTime
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public Date getCreatedatetime() {
        return createdatetime;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column useraccesstoken.CreateDateTime
     *
     * @param createdatetime the value for useraccesstoken.CreateDateTime
     *
     * @mbggenerated Thu Jul 27 14:12:23 CST 2017
     */
    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }
}