package com.viktor.tdd.fluffycloud.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.viktor.tdd.fluffycloud.Catalog;
import com.viktor.tdd.fluffycloud.ItemPriceNotFoundException;
import com.viktor.tdd.fluffycloud.Price;

/**
 * The contract test. It specifies how the catalog should behave. 
 * The abstract methods are meant to be implemented in child for concrete type of catalog
 *  
 * @author z003e2nc
 *
 */
public abstract class FindPriceInCatalogContract
{

  private final String currency ="EUR";
  
  @Test
  public void productFound() throws Exception {
      final Catalog catalog = catalogWith("12345", new Price(currency, 795));
      assertThat(new Price(currency, 795), is(catalog.providePriceForBarcode("12345")));
  }

  protected abstract Catalog catalogWith(String barcode, Price matchingPrice);

  @Test
  public void productNotFound() throws Exception {
      final Catalog catalog = catalogWithout("::barcode not found::");
      try{
        Price p = catalog.providePriceForBarcode("56789");
        fail();
      }catch (ItemPriceNotFoundException expected) {
      
      }
   
  }

  protected abstract Catalog catalogWithout(String barcodeToAvoid);

}
