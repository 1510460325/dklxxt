package cn.wzy.dao;


import cn.wzy.dao.entity.Problem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class ProblemDaoTest {

  @Autowired
  private ProblemDao problemDao;

  @Test
  public void importSingle() throws Exception {
    List<Problem> problems = new ArrayList<>();
    File file = new File("D:\\党课\\source\\single.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
    String str;
    String content = "", a = "", b = "", c = "", d = "", ans = "";
    int flag = 0;
    while ((str = reader.readLine()) != null) {
      if (str.trim().equals("")) {
        continue;
      }
      switch (flag) {
        case 0: {
          content = getContent(str);
          break;
        }
        case 1: {
          ans = str;
          break;
        }
        case 2: {
          a = str.substring(2);
          break;
        }
        case 3: {
          b = str.substring(2);
          break;
        }
        case 4: {
          c = str.substring(2);
          break;
        }
        case 5: {
          d = str.substring(2);
          break;
        }
      }
      flag++;
      if (flag == 6) {
        Problem problem = new Problem(1, 1, content, ans, a, b, c, d, null, null);
        flag = 0;
        problems.add(problem);
        System.out.println(problem);
      }
    }
    problemDao.insertList(problems);
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


  @Test
  public void importMulti() throws Exception {
    List<Problem> problems = new ArrayList<>();
    File file = new File("D:\\党课\\source\\multi.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
    String str;
    String a, b, c, d, e, f, ans, content;
    a = b = c = d = e = f = ans = content = "";
    int t = 0;
    while ((str = reader.readLine()) != null) {
      if (str.trim().equals("")) {
        continue;
      }
      System.out.println(str);
      if (t == 0) {
        content = getContent(str);
      } else if (t == 1) {
        ans = str;
      } else if (t == 2) {
        a = str.substring(2);
      } else if (t == 3) {
        b = str.substring(2);
      } else if (t == 4) {
        c = str.substring(2);
      } else if (t == 5) {
        d = str.substring(2);
      } else if (t == 6) {
        if (str.startsWith("E")) {
          e = str.substring(2);
        } else {
          Problem problem = new Problem(null, 2, content, ans, a, b, c, d, null, null);
          problems.add(problem);
          content = getContent(str);
          t = 0;
        }
      } else if (t == 7) {
        if (str.startsWith("F")) {
          f = str.substring(2);
          Problem problem = new Problem(null, 2, content, ans, a, b, c, d, e, f);
          problems.add(problem);
          t = -1;
        } else {
          Problem problem = new Problem(null, 2, content, ans, a, b, c, d, e, null);
          problems.add(problem);
          content = getContent(str);
          t = 0;
        }
      }
      t++;
    }
    System.out.println(problems);
    problemDao.insertList(problems);
  }


  @Test
  public void importJudge() throws Exception {
    List<Problem> problems = new ArrayList<>();
    File file = new File("D:\\党课\\source\\judge.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
    String str;
    String content = "";
    int t = 0;
    while ((str = reader.readLine()) != null) {
      if (str.trim().equals("")) {
        continue;
      }
      if (t == 0) {
        content = getContent(str);
        t = 1;
      } else if (t == 1) {
        Problem problem = new Problem();
        if (str.equals("√")) {
          problem.setAns("A");
        } else {
          problem.setAns("B");
        }
        problem.setContent(content);
        problem.setOp1("对");
        problem.setOp2("错");
        problem.setType(3);
        problems.add(problem);
        t = 0;
      }
    }
    System.out.println(problems.size());
    problemDao.insertList(problems);
  }
}