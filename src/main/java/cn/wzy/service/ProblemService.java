package cn.wzy.service;

import cn.wzy.dao.entity.Admin;
import cn.wzy.dao.entity.JudgeResult;
import cn.wzy.dao.entity.Problem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProblemService {

	List<Problem> getProblems();

	JudgeResult judge(int id, String ans);

	List<Problem> upload(MultipartFile doc, Integer type);

	void saveProblems(String data);

	boolean login(Admin admin);
}
