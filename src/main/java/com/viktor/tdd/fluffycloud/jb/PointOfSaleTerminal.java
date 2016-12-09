package com.viktor.tdd.fluffycloud.jb;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.viktor.tdd.fluffycloud.ConsoleDisplay;
import com.viktor.tdd.fluffycloud.DummyCatalog;
import com.viktor.tdd.fluffycloud.Price;

public class PointOfSaleTerminal
{

  private static Map<String, Price> prices;

  public PointOfSaleTerminal()
  {
 
  
  }

  public static void main(String[] args)
  { 
    fillPrices();
    new ConsumeTextCommands(
                           new SellOneItemController(
                                                     new DummyCatalog("EUR", prices ),
                                                     new ConsoleDisplay()
                                                    )::onBarcode //you see dat amazing method reference, don't you ?
                            ).consume(
                                      new InputStreamReader(System.in)
                            );

  }

  private static void fillPrices()
  {
    prices = new HashMap<>();
    prices.put("123456", new Price("EUR", 100));
    prices.put("7070529026686", new Price("EUR",1.25));
  }

}
