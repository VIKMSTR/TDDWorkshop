package com.viktor.tdd.fluffycloud;

public class ItemPriceNotFoundException extends Exception
{

  /**
   * 
   */
  private static final long serialVersionUID = -460993423662100043L;

  public ItemPriceNotFoundException(String message){
    super(message);
  }
}
