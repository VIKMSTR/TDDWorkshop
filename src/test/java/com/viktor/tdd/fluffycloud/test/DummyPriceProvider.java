package com.viktor.tdd.fluffycloud.test;

import java.util.HashMap;
import java.util.Map;

import com.viktor.tdd.fluffycloud.ItemPriceNotFoundException;
import com.viktor.tdd.fluffycloud.Price;
import com.viktor.tdd.fluffycloud.PriceProvider;

import lombok.Getter;

public class DummyPriceProvider implements PriceProvider
{

  private final String currency; 
  @Getter
  private Map<String, Price> priceDatabase;
  
  public DummyPriceProvider(String currency){
    priceDatabase = new HashMap<String, Price>();
    this.currency = currency;
    makeDummyPrices();
  }
  

  private void makeDummyPrices()
  {
   priceDatabase.put("000001", new Price(currency,165.20));
   priceDatabase.put("123456", new Price(currency,800.00));
   priceDatabase.put("ABCDEF", new Price(currency,20.20));
   priceDatabase.put("0000000018", new Price(currency, 666.50)); 
  }


  public Price providePriceForBarcode(String barcode) throws ItemPriceNotFoundException
  {
    if(priceDatabase.containsKey(barcode)){
      return priceDatabase.get(barcode);
    }else{
      throw new ItemPriceNotFoundException("Item price not found for barcode " + barcode);
    }
    
  }

}
