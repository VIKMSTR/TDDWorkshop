package com.viktor.tdd.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.viktor.tdd.TestedClass;
public class MyTest
{

  private TestedClass tested;
  public MyTest()
  {
    // TODO Auto-generated constructor stub
  }
  
  @Before
  public void prepare(){
    tested = new TestedClass();
  }
  
  
  @Test
  public void failingTest(){
    fail("Failed");
  }
  
  @Test
  public void sumTest(){
    assertEquals(6, tested.sum(3, 3));
  }

}
