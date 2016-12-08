package com.viktor.tdd.fluffycloud;

public interface IOrder
{

  void addOrder(String barcode, Price price);
  double totalPrice();
  
}
