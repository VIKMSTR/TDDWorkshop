package com.viktor.tdd.fluffycloud;

public class Sale
{

  private final Catalog priceProvider;
  private IOrder openOrder;
  /***
   *
   * @param priceProvider new price provider
   */
  public Sale(Catalog priceProvider)
  {
    this.priceProvider = priceProvider;
  }

  public Price getItemPrice(String string) throws ItemPriceNotFoundException
  {
    return priceProvider.providePriceForBarcode(string);
  }

  
  public void createOrder(){
    openOrder = new Order();
  }
  
  public Price scanItemToOrder(String barcode) throws ItemPriceNotFoundException, NoOrderException{
    Price itemPrice = priceProvider.providePriceForBarcode(barcode); 
    if(openOrder == null) 
      throw new NoOrderException("Order is not created");
    openOrder.addOrder(barcode, itemPrice);
    return itemPrice;
    
    
  }
  
  public double checkout() throws NoOrderException{
    if(openOrder == null) 
      throw new NoOrderException("Order is not created");
    return openOrder.totalPrice();
  }
  
}
