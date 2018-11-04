package cn.wzy.service;

import cn.wzy.dao.entity.JudgeResult;
import cn.wzy.dao.entity.Problem;

import java.util.List;

public interface ProblemService {

  List<Problem> getProblems();
  JudgeResult judge(int id, String ans);
}
