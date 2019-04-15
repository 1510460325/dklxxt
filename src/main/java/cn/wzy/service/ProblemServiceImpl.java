package cn.wzy.service;

import cn.wzy.dao.AdminDao;
import cn.wzy.dao.ProblemDao;
import cn.wzy.dao.entity.Admin;
import cn.wzy.dao.entity.JudgeResult;
import cn.wzy.dao.entity.Problem;
import com.alibaba.fastjson.JSON;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

@Service
public class ProblemServiceImpl implements ProblemService {

	@Autowired
	private ProblemDao dao;

	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean login(Admin admin) {
		if (admin.getUsername() == null || admin.getUsername().trim().equals("")
			|| admin.getPassword() == null || admin.getPassword().trim().equals(""))
			return false;
		return adminDao.count(admin) > 0;
	}

	@Override
	public List<Problem> getProblems() {
		int max = dao.maxId();
		int min = dao.minId();
		int bound = max - min;
		Random random = new Random();
		Set<Integer> set = new HashSet<>();
		while (set.size() < 100) {
			set.add(random.nextInt(bound) + min);
			set.add(random.nextInt(bound) + min);
			set.add(random.nextInt(bound) + min);
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

	@Override
	public void saveProblems(String data) {
		List<Problem> problems = JSON.parseArray(data, Problem.class);
		if (problems != null && problems.size() != 0) {
			dao.delByType(problems.get(0).getType());
			dao.insertList(problems);
		}
	}

	@Override
	public List<Problem> upload(MultipartFile doc, Integer type) {
		String name = System.currentTimeMillis() + doc.getOriginalFilename();
		File path = new File("/tmp/");
		try {
			if (!path.exists())
				path.mkdirs();
			File dest = new File(path, name);
			dest.createNewFile();
			doc.transferTo(dest);
			String docStr = readWord(dest.getPath());
			if (docStr.equals(""))
				return null;
			switch (type) {
				case 1:
					return importSingle(docStr);
				case 2:
					return importMulti(docStr);
				case 3:
					return importJudge(docStr);
				case 4:
					return inportFull(docStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	private String getContent(String str) {
		int index = str.indexOf(".");
		if (index == -1) {
			return str;
		} else if (index < 5) {
			return str.substring(index + 1);
		} else {
			return str;
		}
	}

	private List<Problem> importJudge(String doc) {
		List<Problem> problems = new ArrayList<>();
		String[] strs = doc.split("\n");
		String content = "";
		int t = 0, index = 0;
		while (index < strs.length) {
			if (strs[index].trim().equals("")) {
				index++;
				continue;
			}
			if (t == 0) {
				content = getContent(strs[index]);
				t = 1;
			} else {
				Problem problem = new Problem();
				if (strs[index].equals("√")) {
					problem.setAns("A");
				} else {
					problem.setAns("B");
				}
				problem.setContent("（判断题）" + content);
				problem.setOp1("对");
				problem.setOp2("错");
				problem.setType(3);
				problems.add(problem);
				t = 0;
			}
			index++;
		}
		return problems;
	}

	private List<Problem> importSingle(String doc) {
		List<Problem> problems = new ArrayList<>();
		String[] strs = doc.split("\n");
		String content = "", a = "", b = "", c = "", d = "", ans = "";
		int flag = 0, index = 0;
		while (index < strs.length) {
			if (strs[index].trim().equals("")) {
				index++;
				continue;
			}
			switch (flag) {
				case 0: {
					content = getContent(strs[index]);
					break;
				}
				case 1: {
					ans = strs[index];
					break;
				}
				case 2: {
					a = strs[index].substring(2);
					break;
				}
				case 3: {
					b = strs[index].substring(2);
					break;
				}
				case 4: {
					c = strs[index].substring(2);
					break;
				}
				case 5: {
					d = strs[index].substring(2);
					break;
				}
			}
			index++;
			flag++;
			if (flag == 6) {
				Problem problem = new Problem(1, 1, "（单选题）" + content, ans, a, b, c, d, null, null);
				flag = 0;
				problems.add(problem);
			}
		}
		return problems;
	}

	private List<Problem> importMulti(String doc) {
		List<Problem> problems = new ArrayList<>();
		String[] strs = doc.split("\n");
		String a, b, c, d, e, f, ans, content;
		a = b = c = d = e = f = ans = content = "";
		int t = 0, index = 0;
		while (index < strs.length) {
			if (strs[index].trim().equals("")) {
				index++;
				continue;
			}
			if (t == 0) {
				content = getContent(strs[index]);
			} else if (t == 1) {
				ans = strs[index];
			} else if (t == 2) {
				a = strs[index].substring(2);
			} else if (t == 3) {
				b = strs[index].substring(2);
			} else if (t == 4) {
				c = strs[index].substring(2);
			} else if (t == 5) {
				d = strs[index].substring(2);
			} else if (t == 6) {
				if (strs[index].startsWith("E")) {
					e = strs[index].substring(2);
				} else {
					Problem problem = new Problem(null, 2, "（多选题）" + content, ans, a, b, c, d, null, null);
					problems.add(problem);
					content = getContent(strs[index]);
					t = 0;
				}
			} else if (t == 7) {
				if (strs[index].startsWith("F")) {
					f = strs[index].substring(2);
					Problem problem = new Problem(null, 2, "（多选题）" + content, ans, a, b, c, d, e, f);
					problems.add(problem);
					t = -1;
				} else {
					Problem problem = new Problem(null, 2, "（多选题）" + content, ans, a, b, c, d, e, null);
					problems.add(problem);
					content = getContent(strs[index]);
					t = 0;
				}
			}
			index++;
			t++;
		}
		//处理最后的题目
		Problem problem = new Problem(null, 2, "（多选题）" + content, ans, a, b, c, d, null, null);
		if (t == 7) {
			problem.setOp5(e);
		} else if (t == 0) {
			problem.setOp5(e);
			problem.setOp6(f);
		}
		problems.add(problem);
		return problems;
	}

	private List<Problem> inportFull(String doc) {
		List<Problem> problems = new ArrayList<>();
		String[] strs = doc.split("\n");
		String content = "";
		int t = 0, index = 0;
		while (index < strs.length) {
			if (strs[index].trim().equals("")) {
				index++;
				continue;
			}
			if (t == 0) {
				content = getContent(strs[index]);
				t = 1;
			} else {
				Problem problem = new Problem();
				while (strs[index].contains("  ")) {
					strs[index] = strs[index].replace("  "," ");
				}
				problem.setAns(strs[index].trim().replace(" ", "、"));
				problem.setContent("（填空题）" + content);
				problem.setType(4);
				problems.add(problem);
				t = 0;
			}
			index++;
		}
		return problems;
	}

	private String readWord(String path) {
		String buffer = "";
		try {
			if (path.endsWith(".doc")) {
				InputStream is = new FileInputStream(new File(path));
				WordExtractor ex = new WordExtractor(is);
				buffer = ex.getText();
				ex.close();
			} else if (path.endsWith("docx")) {
				OPCPackage opcPackage = POIXMLDocument.openPackage(path);
				POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
				buffer = extractor.getText();
				extractor.close();
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer;
	}
}
