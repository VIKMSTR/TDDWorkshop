package com.viktor.tdd.fluffycloud;

public class OrderProcessor
{

  private final PriceProvider priceProvider;
  
  /***
   *
   * @param priceProvider new price provider
   */
  public OrderProcessor(PriceProvider priceProvider)
  {
    this.priceProvider = priceProvider;
  }

  public Price getItemPrice(String string) throws ItemPriceNotFoundException
  {
    return priceProvider.providePriceForBarcode(string);
  }

}
