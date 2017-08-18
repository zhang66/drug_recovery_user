package com.blueocean.app.assistantmanage.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blueocean.app.assistantmanage.dao.UserAccessTokenDao;
import com.blueocean.app.assistantmanage.dto.UserAccessTokenDo;
import com.blueocean.app.assistantmanage.dto.UserDto;
import com.blueocean.app.assistantmanage.dto.ValidateUser;
import com.blueocean.app.assistantmanage.service.IUserService;
import com.blueocean.app.assistantmanage.web.LoginUser;
import com.blueocean.app.customermanage.dao.DrugRecycleSiteDao;
import com.blueocean.app.customermanage.dto.DrugRecycleSiteDo;

@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private DrugRecycleSiteDao userDao;
	@Resource
	private UserAccessTokenDao userAccessTokenDoMapper;
	@Override
	public UserDto Loginwithaccountpwd(LoginUser loginuser) {
		DrugRecycleSiteDo selectBypassword = userDao.selectBypassword(loginuser);
		
		
		if(selectBypassword!=null){
		UserDto userDto=new UserDto();
		userDto.setUserId(selectBypassword.getId());
		UserAccessTokenDo generateUserAccessTokenEntity = generateUserAccessTokenEntity(selectBypassword.getId(), loginuser.getUuid(),loginuser.getCid());
		userDto.setSession(generateUserAccessTokenEntity.getSessionkey());
		return userDto;
		}else{
			return null;
		}
		
	}
	
	private UserAccessTokenDo generateUserAccessTokenEntity(int userId, String machineCode,String cid) {
		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar1.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 14);// +7今天的时间加七天

		UserAccessTokenDo tokenEntity = new UserAccessTokenDo();
		tokenEntity.setSessionkey(UUID.randomUUID().toString());
		tokenEntity.setLastaccesstime(calendar.getTime());
		tokenEntity.setTimeout(calendar1.getTime());
		tokenEntity.setUserid(userId);
		tokenEntity.setMachinecode(machineCode);
		tokenEntity.setCreatedatetime(calendar1.getTime());
		tokenEntity.setCid(cid);
//		new UserAccessTokenDao().Create(tokenEntity);
		int insertSelective = userAccessTokenDoMapper.insertSelective(tokenEntity);
		if(insertSelective>0){
			return tokenEntity;
		}else{
			return null;
		}
		
	}
	public String selectCidByUid(Integer userid) {
		List<UserAccessTokenDo> selectByPUserId = userAccessTokenDoMapper.selectByPUserId(userid);
		String cid = "";
		if (selectByPUserId != null && selectByPUserId.size() > 0) {
			cid = selectByPUserId.get(0).getCid();
		}
		return cid;
	}
	@Override
	public ValidateUser checkUser(String session){
		
		UserAccessTokenDo selectBySession = userAccessTokenDoMapper.selectBySession(session);
		
		UserAccessTokenDo newSession=new UserAccessTokenDo();
		ValidateUser validateUser = new ValidateUser(false, "发生未知异常");
		
			if (selectBySession == null) {
				validateUser.setValidate(false);
				validateUser.setMessage("用户验证失败");
				return validateUser;
			}
			List<UserAccessTokenDo> selectByPUserId = userAccessTokenDoMapper.selectByPUserId(selectBySession.getUserid());
			DrugRecycleSiteDo selectBypassword = userDao.selectByPrimaryKey(selectBySession.getUserid());
			Date timeout = selectBySession.getTimeout();
			Long timeSpan = timeout.getTime();
			Long now = new Date().getTime();
			Long minutes = (now - timeSpan) / (1000 * 60); // 相差多少秒
			// 超过14天则超时
			if (minutes > 60 * 24 * 14) {
				validateUser.setValidate(false);
				validateUser.setMessage("用户信息超时");

			} 
			else if(!selectByPUserId.get(0).getSessionkey().equals(session)){
				validateUser.setValidate(false);
				validateUser.setMessage("用户重复登录!");
			}
			else {

				// 插入key和时间戳
				newSession.setTokenid(selectBySession.getTokenid());
				newSession.setTimeout(new Date());
				newSession.setLastaccesskey(UUID.randomUUID().toString());
				userAccessTokenDoMapper.updateByTime(newSession);
				validateUser.setValidate(true);
				validateUser.setMessage("验证成功");
				validateUser.setUserdto(selectBypassword);
			}
		
		return validateUser;
	}
}
