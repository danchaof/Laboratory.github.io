package ay.laboratory.service;

import ay.laboratory.dao.LaboratoryDao;
import ay.laboratory.domain.Laboratory;
import ay.laboratory.domain.PageBean;

import java.sql.SQLException;
import java.util.Map;

public class LaboratoryService{
  private LaboratoryDao dao = new LaboratoryDao();

  public void add(Laboratory laboratory, Map<String, String> errors) throws LaboratoryException { Laboratory l = this.dao.fingByNumber(laboratory.getXh());
    if (l != null) throw new LaboratoryException("提交失败,您已经提交过了表单！");
    if (errors.size() > 0) throw new LaboratoryException("提交失败,请校正注册信息！");
    this.dao.add(laboratory);
  }

  public PageBean<Laboratory> findAll(int pc, int ps) throws SQLException {
    return this.dao.findAll(pc, ps); }

  public Laboratory findByUid(String uid) {
    return this.dao.fingByUid(uid); }

  public void delete(String uid) {
    this.dao.delete(uid);
  }

public PageBean<Laboratory> findByName(String name,int pc,int ps) throws SQLException {
	
	LaboratoryDao dao = new LaboratoryDao();
	PageBean<Laboratory> pb = dao.findByName(name,pc,ps);
	return pb;
}
}