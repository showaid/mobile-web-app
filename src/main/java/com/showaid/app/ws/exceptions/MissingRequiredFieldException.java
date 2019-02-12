package com.showaid.app.ws.exceptions;

public class MissingRequiredFieldException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 5929609251287657851L;
  
  public MissingRequiredFieldException(String message) {
    super(message);
  }
}
