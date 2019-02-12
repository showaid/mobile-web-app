package com.showaid.app.ws.ui.service.impl;

import com.showaid.app.ws.shared.dto.UserDTO;
import com.showaid.app.ws.ui.service.UsersService;
import com.showaid.app.ws.utils.UserProfileUtils;

public class UserServiceImpl implements UsersService {

  UserProfileUtils userProfileUtils = new UserProfileUtils();
  @Override
  public UserDTO createUser(UserDTO user) {
    UserDTO returnValue = new UserDTO();
    
    // Validate the required fields
    userProfileUtils.validateRequiredFields(user);
    
    // Check if user already exists
    
    // Create an Entity object
    
    // Generate secure public user id
    
    // Generate salt
    
    // Generate secure password
    
    // Record data into a database
    
    // Return back the user profile
    return returnValue;
  }

}
