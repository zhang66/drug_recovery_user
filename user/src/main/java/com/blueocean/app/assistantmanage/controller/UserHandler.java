package com.blueocean.app.assistantmanage.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.app.assistantmanage.dto.UserDto;
import com.blueocean.app.assistantmanage.service.IUserService;
import com.blueocean.app.assistantmanage.web.LoginUser;
import com.blueocean.common.constant.RetInfoConstant;
import com.blueocean.common.util.StringUtil;
import com.blueocean.common.utils.RetInfoUtil;
import com.blueocean.common.vo.RetInfo;
import com.blueocean.common.annotation.SerializedField;
import com.blueocean.common.annotation.isNotDecrypt;

@RestController
@SerializedField(encode=true)
@RequestMapping(value = "userMgr")

public class UserHandler {
	@Resource
	private IUserService userService;

	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public RetInfo login(@RequestBody(required = false) LoginUser loginuser) {
		RetInfo retInfo=RetInfoUtil.initRetInfo4SuccTime();
		if(StringUtil.empty(loginuser.getUserName())){
			retInfo.setErrorCode(RetInfoConstant.RETCODE_LOGIN_FAILED);
			retInfo.setErrorMsg("用户名不能为空");
			//return Result.get(ResultCode.FAILED).addMsg("用户名不能为空");
		}
		else if(StringUtil.empty(loginuser.getPassWord())){
			retInfo.setErrorCode(RetInfoConstant.RETCODE_LOGIN_FAILED);
			retInfo.setErrorMsg("密码不能为空");
		}else{
		UserDto loginwithaccountpwd = userService.Loginwithaccountpwd(loginuser);
		
		if(loginwithaccountpwd==null){
			retInfo.setErrorCode(RetInfoConstant.RETCODE_LOGIN_FAILED);
			retInfo.setErrorMsg("用户名或密码不正确");

		}
		retInfo.setData(loginwithaccountpwd);
		}
		return retInfo;
	}

}
