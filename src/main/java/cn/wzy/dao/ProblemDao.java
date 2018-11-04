package cn.wzy.dao;

import cn.wzy.dao.entity.Problem;

import java.util.List;
import java.util.Set;

public interface ProblemDao {
  List<Problem> getProblem(Set<Integer> ids);

  String getAns(Integer id);

  void insertList(List<Problem> list);
}
