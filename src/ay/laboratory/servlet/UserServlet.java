package ay.laboratory.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ay.laboratory.domain.User;
import ay.laboratory.service.UserService;
import ay.laboratory.utils.MD5Utils;
import cn.itcast.servlet.BaseServlet;

public class UserServlet extends BaseServlet {

	// 用户登录
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		// 获取用户数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User suser = (User) session.getAttribute("user");

		if (username != null || password != null) {

			// 传递数据到service层
			UserService service = new UserService();
			User user = null;
			try {
				if(suser==null) {
					user = service.login(MD5Utils.md5(username), MD5Utils.md5(password));					
				}else {
					request.setAttribute("alreadyLogged", "您已登录");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (user != null) {

				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/FindAllServlet?method=index");
				return;
			}
		}
		request.setAttribute("loginError", "用户名或密码错误");
		// response.sendRedirect(request.getContextPath()+"/login.jsp");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	// 用户退出
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}

}
