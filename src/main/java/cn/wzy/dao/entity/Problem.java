package cn.wzy.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {
  private Integer id;
  private Integer type;
  private String content;
  private String ans;
  private String op1;
  private String op2;
  private String op3;
  private String op4;
  private String op5;
  private String op6;
}
