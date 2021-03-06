package service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import mapper.DevUserMapper;
import pojo.DevUser;
import service.DevUserService;



@Service
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper mapper;

	public DevUser login(String devCode, String devPassword) throws Exception {
		// TODO Auto-generated method stub
		DevUser user = null;
		user = mapper.getLoginUser(devCode);
		//匹配密码
		if(null != user){
			if(!user.getDevPassword().equals(devPassword))
				user = null;
		}
		return user;
	}

}
