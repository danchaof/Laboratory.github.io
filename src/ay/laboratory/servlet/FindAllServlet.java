package ay.laboratory.servlet;

import ay.laboratory.domain.PageBean;
import ay.laboratory.domain.User;
import ay.laboratory.service.LaboratoryService;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindAllServlet extends HttpServlet {
	private LaboratoryService service = new LaboratoryService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null) {
			
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//当前页
			int pc = getPc(request);
			//每页显示10条数据
			int ps = 10;
			PageBean pb;
			try {
				pb = this.service.findAll(pc, ps);
				request.setAttribute("pb", pb);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/information.jsp").forward(request, response);
		}else {
			
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