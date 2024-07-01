package portfolio.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portfolio.dao.UserDao;
import portfolio.dao.entity.UserEntity;
import portfolio.logic.UserLogic;

@Service
public class UserLogicImpl implements UserLogic {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserEntity findUserByUsername(String username, String system) {
		
		return userDao.findUserByUsername(username, system);
	}

}
