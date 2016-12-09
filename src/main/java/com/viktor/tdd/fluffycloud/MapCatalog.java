package com.viktor.tdd.fluffycloud;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class MapCatalog implements Catalog
{

  private Map<String, Price> priceDatabase;
  public MapCatalog(ImmutableMap<String, Price> priceDatabase)
  {
    this.priceDatabase = priceDatabase;
  }

  @Override
  public Price providePriceForBarcode(String barcode) throws ItemPriceNotFoundException
  {
  //check for empty string
    if(priceDatabase.containsKey(barcode)){
      return priceDatabase.get(barcode);
    }else{
      throw new ItemPriceNotFoundException("Item price not found for barcode " + barcode);
    }
  }

}
