package com.viktor.tdd.fluffycloud;

public interface PriceProvider
{

  Price providePriceForBarcode(String barcode) throws ItemPriceNotFoundException;
  
}
