package com.viktor.tdd.fluffycloud;

public class ConsoleDisplay implements Display
{

  public ConsoleDisplay()
  {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void printPrice(String price)
  {
    System.out.println(price);

  }

  @Override
  public void printProductNotFound()
  {
    System.err.println(":: No barcode found ::");

  }

  @Override
  public void printEmptyBarcodeMessage()
  {
    System.err.println(":: Barcode is empty ::");

    
  }

}
