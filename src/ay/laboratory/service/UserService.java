package ay.laboratory.service;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import ay.laboratory.dao.UserDao;
import ay.laboratory.domain.User;
import ay.laboratory.utils.DataSourceUtils;

public class UserService {

	public User login(String username, String password) throws SQLException {
		
		UserDao dao = new UserDao();
		
		User user = dao.findUser(username,password);
		return user;
	}

}
