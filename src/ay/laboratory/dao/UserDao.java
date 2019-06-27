package ay.laboratory.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import ay.laboratory.domain.User;
import ay.laboratory.utils.DataSourceUtils;

public class UserDao {

	public User findUser(String username, String password) throws SQLException {
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = (User) runner.query(sql, new BeanHandler<User>(User.class), username,password);
		return user;
	}

}
