package ay.laboratory.servlet;

import ay.laboratory.domain.Laboratory;
import ay.laboratory.domain.User;
import ay.laboratory.service.LaboratoryService;
import cn.itcast.servlet.BaseServlet;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindByUid extends HttpServlet {
	
	private LaboratoryService service = new LaboratoryService();
	
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		try {
			// 获取请求的method的名称
			String methodName = req.getParameter("method");
			// 获取当前对象的字节码
			Class clazz = this.getClass();
			// 获得当前字节码中指定的方法
			Method method = null;
			if(methodName==null) {
				methodName = "query";
				method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
				Object invoke = method.invoke(this, req, resp);
			}else {
				method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
				Object invoke = method.invoke(this, req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	FindAllServlet all = new FindAllServlet();

	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			String uid = request.getParameter("uid");

			Laboratory laboratory = this.service.findByUid(uid);
			request.setAttribute("person", laboratory);
			request.getRequestDispatcher("/personal.jsp").forward(request, response);

		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			String uid = request.getParameter("uid");
			this.service.delete(uid);
			response.sendRedirect(request.getContextPath() + "/FindAllServlet");
		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}
}