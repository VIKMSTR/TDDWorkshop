package com.viktor.tdd.fluffycloud;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrder
{

  List<OrderItem> orderItems;
  
  public Order(){
    orderItems = new ArrayList<>();
  }
  
  public void addOrder(String barcode, Price price)
  {
    orderItems.add(new OrderItem(barcode, price));
    
  }

  public double totalPrice()
  {
    return orderItems.stream().mapToDouble(item -> item.getItemPrice().getValue()).sum();
  }

}
