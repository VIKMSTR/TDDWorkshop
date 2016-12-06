package com.viktor.tdd.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.viktor.tdd.TestedClass;
/***
 * 
 * @author z003e2nc
 *
 * Hamcrest wiki: https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki
 */
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
    tested.setField(5);
    assertEquals(5, tested.getField());
    assertEquals(6, tested.sum(3, 3));
    assertThat("sum",tested.sum(3, 3), equalTo(6));
  }

}
