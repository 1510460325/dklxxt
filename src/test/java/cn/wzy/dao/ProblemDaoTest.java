package cn.wzy.dao;


import cn.wzy.dao.entity.Problem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class ProblemDaoTest {

  @Autowired
  private ProblemDao problemDao;

  @Test
  public void test() {
    Set<Integer> ids = new HashSet<>();
    ids.add(1);
    ids.add(2);
    Problem problem = new Problem();
    System.out.println(problemDao.getProblem(ids));
  }
}
