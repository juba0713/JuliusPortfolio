package portfolio.controllers.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import portfolio.dao.UserDao;
import portfolio.dao.entity.UserEntity;



public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userDao.findUserByUsername(username, "none");
	       
        return new User(
        		user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole())
        );
	}

   
}
