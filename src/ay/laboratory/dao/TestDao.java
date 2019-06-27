package ay.laboratory.dao;

import ay.laboratory.domain.Laboratory;
import cn.itcast.commons.CommonUtils;
import org.junit.Test;

public class TestDao
{
  @Test
  public void fun()
  {
    LaboratoryDao dao = new LaboratoryDao();
    Laboratory l = new Laboratory();
    for (int i = 0; i < 300; ++i) {
      l.setName("laboratory_" + i);
      l.setSex((i % 2 == 0) ? "男" : "女");
      l.setTel("10372737" + i);
      l.setNl("我是学生");
      l.setXh("1031010" + i);
      l.setZy("计算机科学与技术");
      l.setNl("我会玩电脑");
      l.setUid(CommonUtils.uuid());
      dao.add(l);
    }
  }
}