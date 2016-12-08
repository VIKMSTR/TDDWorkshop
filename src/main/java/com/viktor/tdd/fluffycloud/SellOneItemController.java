package com.viktor.tdd.fluffycloud;

public class SellOneItemController
{

  private Catalog catalog;
  private Display display;

  public SellOneItemController(Catalog catalog, Display display)
  {
    this.catalog = catalog;
    this.display = display;
  }

  public void onBarcode(String barcode)
  {
    // handle display
    if ("".equals(barcode))
    {
      display.printEmptyBarcodeMessage();
    }
    try
    {
      final Price price = catalog.providePriceForBarcode(barcode);
      display.printPrice(price.toString());
    }
    catch (ItemPriceNotFoundException notFoundException)
    {
      display.printProductNotFound();
    }

  }

}
