package com.viktor.tdd.fluffycloud.test;

import java.util.HashMap;
import java.util.Map;

import com.viktor.tdd.fluffycloud.Catalog;
import com.viktor.tdd.fluffycloud.Price;

public  class FindPriceDummyCatalogTest extends FindPriceInCatalogContract
{


  @Override
  protected Catalog catalogWith(String barcode, Price matchingPrice){
    Map<String, Price> pricesDB = new HashMap<>();
    pricesDB.put("not" + barcode, new Price("EUR", 300));
    pricesDB.put(barcode, matchingPrice);
    pricesDB.put("also not" + barcode, new Price("EUR", 300));
    return new DummyCatalog("EUR", pricesDB);
  }

  @Override
  protected Catalog catalogWithout(String barcodeToAvoid)
  {
    Map<String, Price> pricesDB = new HashMap<>();
    pricesDB.put("not" + barcodeToAvoid, new Price("EUR", 300));
    pricesDB.put(barcodeToAvoid, new Price("EUR", 400));
    pricesDB.put("also not" + barcodeToAvoid, new Price("EUR", 300));
    return new DummyCatalog("EUR", pricesDB);
  }
  

}
