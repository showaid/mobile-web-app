package com.showaid.app.ws.ui.service.impl;

import com.showaid.app.ws.exceptions.CouldNotCreateRecordException;
import com.showaid.app.ws.io.dao.DAO;
import com.showaid.app.ws.io.dao.impl.MySQLDAO;
import com.showaid.app.ws.shared.dto.UserDTO;
import com.showaid.app.ws.ui.model.response.ErrorMessages;
import com.showaid.app.ws.ui.service.UsersService;
import com.showaid.app.ws.utils.UserProfileUtils;

public class UserServiceImpl implements UsersService {
  DAO database;
  
  public UserServiceImpl() {
    this.database = new MySQLDAO();
  }
  
  UserProfileUtils userProfileUtils = new UserProfileUtils();
  @Override
  public UserDTO createUser(UserDTO user) {
    UserDTO returnValue = null;
    
    // Validate the required fields
    userProfileUtils.validateRequiredFields(user);
    
    // Check if user already exists
    UserDTO existingUser = this.getUserByUserName(user.getEmail());
    
    if (existingUser != null) {
      throw new CouldNotCreateRecordException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
    }
    
    // Generate secure public user id
    String userId = userProfileUtils.generateUserId(30);
    user.setUserId(userId);
    
    // Generate salt
    String salt = userProfileUtils.generateSalt(30);
    // Generate secure password
    String encryptedPassword = userProfileUtils.generateSecurePassword(user.getPassword(), salt);
    
    user.setSalt(salt);
    user.setEncryptedPassword(encryptedPassword);
    
    // Record data into a database
    returnValue = this.saveUser(user);
    
    // Return back the user profile
    return returnValue;
  }
  
  private UserDTO saveUser(UserDTO user) {
    UserDTO returnValue = null;
    try {
      this.database.openConnection();
      returnValue = this.database.saveUser(user);
    } finally {
      this.database.closeConnection();
    }
    return returnValue;
  }
  
  private UserDTO getUserByUserName(String userName) {
    UserDTO userDto = null;
    
    if (userName == null || userName.isEmpty())
      return userDto;
    
    try {
      this.database.openConnection();
      userDto = this.database.getUserByUserName(userName);
    } finally {
      this.database.closeConnection();
    }
    return userDto;
  }

}
