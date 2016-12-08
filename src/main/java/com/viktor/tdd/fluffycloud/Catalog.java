package com.viktor.tdd.fluffycloud;

public interface Catalog
{

  Price providePriceForBarcode(String barcode) throws ItemPriceNotFoundException;
  
}
