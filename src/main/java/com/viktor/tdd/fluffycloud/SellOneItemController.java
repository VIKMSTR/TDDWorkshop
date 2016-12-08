package com.viktor.tdd.fluffycloud;

public class SellOneItemController implements Controller
{

  private Catalog catalog;
  private Display display;

  public SellOneItemController(Catalog catalog, Display display)
  {
    this.catalog = catalog;
    this.display = display;
  }

  /* (non-Javadoc)
   * @see com.viktor.tdd.fluffycloud.Controller#onBarcode(java.lang.String)
   */
  @Override
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
