package com.viktor.tdd.fluffycloud;

import java.util.Locale;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class Price
{

 private String currency;
 private double value;

 @Override
 public String toString(){
   return currency + " " +  String.format(Locale.ROOT, "%.2f", value);
 }
}
