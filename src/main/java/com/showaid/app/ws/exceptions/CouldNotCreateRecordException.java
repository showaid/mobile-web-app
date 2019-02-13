package com.showaid.app.ws.exceptions;

public class CouldNotCreateRecordException extends RuntimeException {
 
  /**
   * 
   */
  private static final long serialVersionUID = 7100774675724115330L;

  public CouldNotCreateRecordException(String message) {
    super(message);
  }
}
