package com.viktor.tdd.fluffycloud;

public class NoOrderException extends Exception
{

  public NoOrderException()
  {
    super();
  }

  public NoOrderException(String message)
  {
    super(message);
  
  }

  public NoOrderException(Throwable cause)
  {
    super(cause);
  
  }

  public NoOrderException(String message, Throwable cause)
  {
    super(message, cause);
  
  }

  public NoOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);

  }

}
