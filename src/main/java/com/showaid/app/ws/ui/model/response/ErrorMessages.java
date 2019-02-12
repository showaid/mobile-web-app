package com.showaid.app.ws.ui.model.response;

public enum ErrorMessages {
  
  MISSING_REQUIRED_FIELD("Missing required. Please check documentation for required fields"),
  RECORD_ALREADY_EXISTS("Record alread exists"),
  INTERNAL_SERVER_ERROR("Internal Server Error");
  
  private String errorMessage;
  
  ErrorMessages(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
