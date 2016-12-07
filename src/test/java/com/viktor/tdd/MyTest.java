package com.viktor.tdd;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
/***
 * 
 * @author z003e2nc
 *
 * Hamcrest wiki: https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki
 */
public class MyTest
{

  private TestedClass tested;
  private Fraction testedFraction;
  public MyTest()
  {
    // TODO Auto-generated constructor stub
  }
  
  @Before
  public void prepare(){
    tested = new TestedClass();
    
  }
      
  @Test
  public void zeroFractionwSum(){
    testedFraction = new Fraction(0, 0);
    assertThat("Is Initialized", testedFraction.getNominator(), equalTo(0));
    assertThat("Is Initialized", testedFraction.getDenominator(), equalTo(0));
    
    Fraction result = testedFraction.plus(testedFraction);
    assertThat("Zero sum", result.getNominator(), equalTo(0));
    assertThat("zero sum", result.getDenominator(), equalTo(0));
  }
  
  @Test
  public void addFractions(){
    testedFraction = new Fraction(2, 3);
    Fraction addedFraction = new Fraction(4,2);
    Fraction result = testedFraction.plus(addedFraction);
    assertThat("sum", result.getNominator(), equalTo(16));
    assertThat("sum", result.getDenominator(), equalTo(6));
  }
  
  @Test
  public void addFractionWithZero(){
    testedFraction = new Fraction(2, 3);
    Fraction addedFraction = new Fraction(0,0);
    Fraction result = testedFraction.plus(addedFraction);
    assertThat("Zero sum", result.getNominator(), equalTo(2));
    assertThat("zero sum", result.getDenominator(), equalTo(3));
  }
  
  @Test(expected=NumberFormatException.class)
  public void tryToAddInvalidNumber(){
    testedFraction = new Fraction(2, 3);
    Fraction addedFraction = new Fraction(6,0);
    Fraction result = testedFraction.plus(addedFraction);
    assertThat("Zero sum", result.getNominator(), equalTo(2));
    assertThat("zero sum", result.getDenominator(), equalTo(3));
  }
  
  @Test
  public void testDecadic(){
    testedFraction = new Fraction(1, 2);
    Fraction addedFraction = new Fraction(1,2);
    Fraction result = testedFraction.plus(addedFraction);
    assertThat("sum", result.toDecadic(), equalTo(1.0));
    
  }
  @Ignore("refactoring")
  @Test
  public void testOverflow(){
    testedFraction = new Fraction(1, 1);
    Fraction addedFraction = new Fraction(Integer.MAX_VALUE,Integer.MAX_VALUE);
    Fraction result = testedFraction.plus(addedFraction);
    assertThat("sum", result.toDecadic(), equalTo((double)Integer.MIN_VALUE));
    
  }
  


}
