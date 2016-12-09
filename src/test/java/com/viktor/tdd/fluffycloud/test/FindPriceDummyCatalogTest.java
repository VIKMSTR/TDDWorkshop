package com.viktor.tdd.fluffycloud.test;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.viktor.tdd.fluffycloud.Catalog;
import com.viktor.tdd.fluffycloud.MapCatalog;
import com.viktor.tdd.fluffycloud.Price;

/***
 * The test that extends the Contract test. This initialize the specific Catalog type In this case - Dummy Catalog. The
 * tests in parent are ran to fulfill the contract.
 * 
 * @author z003e2nc
 */
public class FindPriceDummyCatalogTest extends FindPriceInCatalogContract
{

  @Override
  protected Catalog catalogWith(String barcode, Price matchingPrice)
  {
    Map<String, Price> pricesDB = new HashMap<>();
    pricesDB.put("not" + barcode, new Price("EUR", 300));
    pricesDB.put(barcode, matchingPrice);
    pricesDB.put("also not" + barcode, new Price("EUR", 300));
    return new MapCatalog(ImmutableMap.of("12345", new Price("EUR", 795), "7070529026686", new Price("EUR", 1.25)));
  }

  @Override
  protected Catalog catalogWithout(String barcodeToAvoid)
  {
    Map<String, Price> pricesDB = new HashMap<>();
    pricesDB.put("not" + barcodeToAvoid, new Price("EUR", 300));
    pricesDB.put(barcodeToAvoid, new Price("EUR", 400));
    pricesDB.put("also not" + barcodeToAvoid, new Price("EUR", 300));
    return new MapCatalog(ImmutableMap.of("12345", new Price("EUR", 795), "7070529026686", new Price("EUR", 1.25)));
  }

}
