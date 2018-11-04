package cn.wzy.service;

import cn.wzy.dao.ProblemDao;
import cn.wzy.dao.entity.JudgeResult;
import cn.wzy.dao.entity.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class ProblemServiceImpl implements ProblemService {

  @Autowired
  private ProblemDao dao;

  private Random random = new Random();

  public static volatile int bound = 500;

  @Override
  public List<Problem> getProblems() {
    Set<Integer> set = new HashSet<>();
    while (set.size() < 40) {
      set.add(random.nextInt(bound) + 1);
    }
    return dao.getProblem(set);
  }

  @Override
  public JudgeResult judge(int id, String ans) {
    String tmp = dao.getAns(id);
    if (tmp.equals(ans)) {
      return new JudgeResult(1, ans);
    } else {
      return new JudgeResult(-1, tmp);
    }
  }
}
