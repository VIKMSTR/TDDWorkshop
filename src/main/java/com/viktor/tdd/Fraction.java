package com.viktor.tdd;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Fraction
{

  @Getter
  private final int nominator;
  @Getter
  private final int denominator;

  public Fraction(int number)
  {
    this(number, 1);
  }

  public Fraction(int nominator, int denominator)
  {
    this.nominator = nominator;
    this.denominator = denominator;
  }

  public Fraction plus(Fraction f) throws NumberFormatException
  {
    int resultNominator;
    int resultDenominator = denominator * f.denominator;

    if (isInvalidNumber(this) || isInvalidNumber(f))
    {
      throw new NumberFormatException("Not a valid number");
    }
    if (isZeroNumber(this))
    {
      return new Fraction(f.nominator, f.denominator);
    }
    if (isZeroNumber(f))
    {
      return new Fraction(nominator, denominator);
    }

    resultNominator = resultDenominator / denominator * nominator + resultDenominator / f.denominator * f.nominator;
    return new Fraction(resultNominator, resultDenominator);
  }

  private static boolean isInvalidNumber(Fraction f)
  {
    return f.getDenominator() == 0 && f.getNominator() != 0;
  }

  private static boolean isZeroNumber(Fraction f)
  {
    return f.denominator == 0 && f.nominator == 0;
  }

  public double toDecadic()
  {
    return nominator / (double)denominator;

  }
  
 
  
}
