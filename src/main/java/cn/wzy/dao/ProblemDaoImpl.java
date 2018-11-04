package cn.wzy.dao;

import cn.wzy.dao.entity.Problem;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class ProblemDaoImpl extends SqlSessionDaoSupport implements ProblemDao {

  private String getNamespace() {
    return "cn.wzy.dao.ProblemDao";
  }

  @Override
  public List<Problem> getProblem(Set<Integer> ids) {
    Map<String,Object> map = new HashMap<>();
    map.put("ids", ids);
    return this.getSqlSession().selectList(getNamespace() + ".getProblem", map);
  }

  @Override
  public String getAns(Integer id) {
    return this.getSqlSession().selectOne(getNamespace() + ".getAns",id);
  }

  @Override
  public void insertList(List<Problem> list) {
    this.getSqlSession().insert(getNamespace() + ".insertList",list);
  }
}
