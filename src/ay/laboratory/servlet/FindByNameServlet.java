package ay.laboratory.servlet;

import ay.laboratory.domain.PageBean;
import ay.laboratory.domain.User;
import ay.laboratory.service.LaboratoryService;
import cn.itcast.servlet.BaseServlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindByNameServlet extends HttpServlet {

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
				methodName = "findByNameInfo";
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
	
	public void findByNameInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LaboratoryService service = new LaboratoryService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String name = request.getParameter("sname");

			//当前页
			int pc = getPc(request);
			//每页显示条数
			int ps = 10;
			//分页数据
			PageBean pb;
			try {
				pb = service.findByName(name,pc,ps);
				request.setAttribute("pb", pb);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/information.jsp").forward(request, response);
		} else {

			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

	private int getPc(HttpServletRequest request) throws ServletException, IOException {
		String pc = request.getParameter("pc");
		if ((pc == null) || (pc.trim().isEmpty()))
			return 1;
		int pc1 = Integer.parseInt(pc);
		return pc1;
	}

}