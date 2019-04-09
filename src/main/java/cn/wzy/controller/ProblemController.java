package cn.wzy.controller;

import cn.wzy.dao.entity.Admin;
import cn.wzy.dao.entity.Problem;
import cn.wzy.service.ProblemService;
import cn.wzy.service.ProblemServiceImpl;
import org.cn.wzy.controller.BaseController;
import org.cn.wzy.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
  @RequestMapping(value = "/uploadDoc.do",method = RequestMethod.POST)
  public ResultModel upload(MultipartFile doc, Integer type){
		if (getSessionValue("user") == null){
			return ResultModel.builder().code(SUCCESS).data("未登录").build();
		}
    return ResultModel.builder().code(SUCCESS).data(service.upload(doc,type)).build();
  }

	@ResponseBody
	@RequestMapping(value = "/uploadList.do",method = RequestMethod.POST)
	public ResultModel uploadList(@RequestBody String data){
		if (getSessionValue("user") == null){
			return ResultModel.builder().code(SUCCESS).data("未登录").build();
		}
  	service.saveProblems(data);
		return ResultModel.builder().code(SUCCESS).data(true).build();
	}

	@ResponseBody
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public ResultModel login(Admin admin){
		if (service.login(admin)){
			getRequest().getSession().setAttribute("user",1234);
			return ResultModel.builder().code(SUCCESS).data(true).build();
		} else {
			return ResultModel.builder().code(SUCCESS).data(false).build();
		}
	}

}
