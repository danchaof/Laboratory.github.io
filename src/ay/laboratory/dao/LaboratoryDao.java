package ay.laboratory.dao;

import cn.itcast.jdbc.TxQueryRunner;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import ay.laboratory.domain.Laboratory;
import ay.laboratory.domain.PageBean;

public class LaboratoryDao {
	private QueryRunner qr = new TxQueryRunner();

	public void add(Laboratory laboratory) {
		String sql = "insert into laboratory values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { laboratory.getName(), laboratory.getSex(), laboratory.getZy(), laboratory.getBm(),
				laboratory.getXh(), laboratory.getTel(), laboratory.getJn(), laboratory.getNl(), laboratory.getUid() };
		try {
			this.qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Laboratory fingByNumber(String number) {
		String sql = "select * from laboratory where xh=?";
		try {
			return ((Laboratory) this.qr.query(sql, new BeanHandler(Laboratory.class), new Object[] { number }));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public PageBean<Laboratory> findAll(int pc, int ps) throws SQLException {
		/*
		 * try{ PageBean pb = new PageBean(); pb.setPc(pc); pb.setPs(ps);
		 * 
		 * String sq = "select count(*) from laboratory"; Number ntr =
		 * (Number)this.qr.query(sq, new ScalarHandler()); int tr = ntr.intValue();
		 * pb.setTr(tr); if (tr % ps == 0) pb.setTp(tr / ps); else { pb.setTp(tr / ps +
		 * 1); }
		 * 
		 * String sql = "select * from laboratory order by name limit ?,?"; Object[]
		 * params = { Integer.valueOf((pc - 1) * ps), Integer.valueOf(ps) }; List
		 * beanlist = (List)this.qr.query(sql, new BeanListHandler(Laboratory.class),
		 * params); pb.setBeanlist(beanlist);
		 * 
		 * return pb; } catch (SQLException e) { throw new RuntimeException(e); }
		 */
		PageBean pb = new PageBean();
		pb.setPc(pc);
		pb.setPs(ps);

		String sq = "select count(*) from laboratory";
		Number ntr = (Number) this.qr.query(sq, new ScalarHandler());
		int tr = ntr.intValue();
		pb.setTr(tr);
		if (tr % ps == 0)
			pb.setTp(tr / ps);
		else {
			pb.setTp(tr / ps + 1);
		}

		String sql = "select * from laboratory order by name limit ?,?";
		Object[] params = { Integer.valueOf((pc - 1) * ps), Integer.valueOf(ps) };
		List beanlist = (List) this.qr.query(sql, new BeanListHandler(Laboratory.class), params);
		pb.setBeanlist(beanlist);

		return pb;
	}

	public Laboratory fingByUid(String uid) {
		String sql = "select * from laboratory where uid=?";
		try {
			return ((Laboratory) this.qr.query(sql, new BeanHandler(Laboratory.class), new Object[] { uid }));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String uid) {
		try {
			String sql = "delete from laboratory where uid=?";
			this.qr.update(sql, uid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据姓名查询信息
	public PageBean<Laboratory> findByName(String name,int pc, int ps) throws SQLException {

		PageBean pb = new PageBean();
		pb.setPc(pc);
		pb.setPs(ps);
		
		String sq = "select count(*) from laboratory";
		Number ntr = (Number) this.qr.query(sq, new ScalarHandler());
		int tr = ntr.intValue();
		pb.setTr(tr);
		if (tr % ps == 0)
			pb.setTp(tr / ps);
		else {
			pb.setTp(tr / ps + 1);
		}

		String sql = "select * from laboratory where name like '%"+name+"%' limit ?,?";
		Object[] params = { Integer.valueOf((pc - 1) * ps), Integer.valueOf(ps) };
		List list = (List) this.qr.query(sql, new BeanListHandler(Laboratory.class), params);
		pb.setBeanlist(list);
		return pb;
	}
}