package com.viktor.tdd.fluffycloud.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.viktor.tdd.fluffycloud.DummyCatalog;
import com.viktor.tdd.fluffycloud.ItemPriceNotFoundException;
import com.viktor.tdd.fluffycloud.Sale;
import com.viktor.tdd.fluffycloud.Price;

public class OrderingTest
{
  Sale orderProcessor;
  String currency;
  
  
  @Before
  public void prepareOrders()
  {
    currency = "EUR";
    orderProcessor = new Sale(new DummyCatalog(currency));
  }

  @Test
  public void sellOneItemTest() throws ItemPriceNotFoundException
  {
    Price price = orderProcessor.getItemPrice("0000000018");
    assertThat(price.getCurrency(), is(currency));
    assertThat(price.getValue(), is(666.50));

  }

 
  
  @Test
  public void testIfSeparatorIsDot() throws ItemPriceNotFoundException
  {
    Price price = orderProcessor.getItemPrice("0000000018");
    assertThat(price.getCurrency(), is(currency));
    assertTrue(price.toString().contains("."));
  }

  @Test
  public void testIfThePriceIsMissing()
  {
    try
    {
      orderProcessor.getItemPrice("BLAH");
      fail();
    }
    catch (ItemPriceNotFoundException expected)
    {
    }
  }
}
