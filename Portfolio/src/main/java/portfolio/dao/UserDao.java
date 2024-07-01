package portfolio.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import portfolio.dao.entity.UserEntity;


@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>{
	
	final String FIND_USER_BY_USERNAME = "SELECT e "
			+ "FROM UserEntity e "
			+ "WHERE e.username = :username "
			+ "AND e.system = :system "
			+ "AND e.deleteFlg = false";
	
	@Query(value=FIND_USER_BY_USERNAME)
	public UserEntity findUserByUsername(@Param("username") String username,
			@Param("system") String system) throws DataAccessException;
}
