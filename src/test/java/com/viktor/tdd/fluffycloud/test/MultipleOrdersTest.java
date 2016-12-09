package com.viktor.tdd.fluffycloud.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.viktor.tdd.fluffycloud.DummyCatalog;
import com.viktor.tdd.fluffycloud.ItemPriceNotFoundException;
import com.viktor.tdd.fluffycloud.NoOrderException;
import com.viktor.tdd.fluffycloud.Sale;

public class MultipleOrdersTest
{

  private Sale sale;

  @Before
  public void setupTheSystem()
  {
    sale = new Sale(new DummyCatalog("EUR"));
  }

  @Test
  public void testIfOrdersAreCalculated() throws ItemPriceNotFoundException, NoOrderException
  {
    sale.createOrder();
    sale.scanItemToOrder("000001");
    sale.scanItemToOrder("000001");
    double result = sale.checkout();

    assertThat(result, is(165.20 * 2));
    // Assert.fail();
  }

  @Test
  public void testIfOrderIsNotClosedAfterCheckout() throws ItemPriceNotFoundException, NoOrderException
  {
    sale.createOrder();
    sale.scanItemToOrder("000001");
    sale.scanItemToOrder("000001");
    sale.checkout();
    sale.scanItemToOrder("000001");
    double result = sale.checkout();
    assertThat(result, is(165.20 * 3));

  }

  @Test
  public void testIfOrderIsNotCreatedButUserWantsToAddAnItem() throws ItemPriceNotFoundException, NoOrderException
  {
    try
    {
      sale.scanItemToOrder("000001");
      Assert.fail();
    }
    catch (NoOrderException e)
    {
    }

  }
}
