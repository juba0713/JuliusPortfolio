package portfolio.logic;

import org.springframework.stereotype.Service;

import portfolio.dao.entity.UserEntity;

@Service
public interface UserLogic {
	
	public UserEntity findUserByUsername(String username, String system);
}
