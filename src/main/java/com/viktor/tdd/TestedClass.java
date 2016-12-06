package com.viktor.tdd;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class TestedClass
{

  public TestedClass()
  {
    // TODO Auto-generated constructor stub
  }
  
  @Getter
  @Setter
  int field;

  public int sum(int a, int b){
    return a +b;
  }
  
}
