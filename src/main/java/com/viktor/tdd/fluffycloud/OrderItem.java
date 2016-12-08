package com.viktor.tdd.fluffycloud;

import lombok.Value;

@Value
public class OrderItem
{
  String barcode;
  Price itemPrice;
}
