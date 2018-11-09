package cn.wzy.controller;

import cn.wzy.dao.entity.Problem;
import cn.wzy.service.ProblemService;
import cn.wzy.service.ProblemServiceImpl;
import org.cn.wzy.controller.BaseController;
import org.cn.wzy.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.cn.wzy.model.ResultModel.ERROR;
import static org.cn.wzy.model.ResultModel.SUCCESS;

@Controller
public class ProblemController extends BaseController {

  @Autowired
  private ProblemService service;

  @ResponseBody
  @RequestMapping("/getPro.do")
  public ResultModel getProblem() {
    List<Problem> result = service.getProblems();
    return ResultModel.builder().data(result).code(SUCCESS).total(result == null?0:result.size()).build();
  }

  @ResponseBody
  @RequestMapping("/judge.do")
  public ResultModel judge(Integer id, String ans) {
    return ResultModel.builder().data(service.judge(id, ans)).code(SUCCESS).build();
  }

  @ResponseBody
  @RequestMapping("/change.do")
  public ResultModel change(Integer bound, String verify) {
    if (!"asdf".equals(verify)) {
      return ResultModel.builder().code(ERROR).build();
    }
    ProblemServiceImpl.bound = bound;
    return ResultModel.builder().code(SUCCESS).build();
  }
}
