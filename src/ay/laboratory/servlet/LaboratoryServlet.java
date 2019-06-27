package ay.laboratory.servlet;

import ay.laboratory.domain.Laboratory;
import ay.laboratory.service.LaboratoryException;
import ay.laboratory.service.LaboratoryService;
import cn.itcast.commons.CommonUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LaboratoryServlet extends HttpServlet{
  private LaboratoryService service = new LaboratoryService();

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    Laboratory laboratory = (Laboratory)CommonUtils.toBean(request.getParameterMap(), Laboratory.class);
    laboratory.setUid(CommonUtils.uuid());
    Map errors = new HashMap();

    String username = laboratory.getName();
    if ((username == null) || (username.trim().isEmpty()) || (username.length() > 5) || (username.length() < 2)) {
      errors.put("username", "");
    }

    String xh = laboratory.getXh();

    if ((xh == null) || (xh.trim().isEmpty()) || (xh.length() != 11)) {
      errors.put("xh", "");
    }

    String tel = laboratory.getTel();
    if ((tel == null) || (tel.trim().isEmpty()) || (tel.length() != 11)) {
      errors.put("tel", "");
    }
    try{
      this.service.add(laboratory, errors);
      response.getWriter().print("注册信息成功！");
    } catch (LaboratoryException e) {
      response.getWriter().print(e.getMessage());
    }
  }
}