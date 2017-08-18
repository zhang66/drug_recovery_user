package com.blueocean.app.assistantmanage.service;

import com.blueocean.app.assistantmanage.dto.UserDto;
import com.blueocean.app.assistantmanage.dto.ValidateUser;
import com.blueocean.app.assistantmanage.web.LoginUser;

public interface IUserService {
	UserDto Loginwithaccountpwd(LoginUser loginuser);
	ValidateUser checkUser(String session);
	
	String selectCidByUid(Integer userid);
}
