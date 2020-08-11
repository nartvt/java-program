package com.spring.program.dto;

import com.spring.program.entity.UserEntity;

/**
 * The Class UserDTO.
 */
public class UserDTO {

  /** The user id. */
  private long userId;

  /** The user name. */
  private String userName;

  /** The age. */
  private int age;

  /** The email. */
  private String email;

  /**
   * Instantiates a new user DTO.
   */
  public UserDTO() {

  }

  /**
   * Instantiates a new user DTO.
   *
   * @param entity
   *          the entity
   */
  public UserDTO(final UserEntity entity) {
    this.userId = entity.getUserId();
    this.userName = entity.getUserName();
    this.age = entity.getAge();
    this.email = entity.getEmail();
  }

  /**
   * Gets the user id.
   *
   * @return the user id
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets the user id.
   *
   * @param userId
   *          the new user id
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Gets the user name.
   *
   * @return the user name
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the user name.
   *
   * @param userName
   *          the new user name
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Gets the age.
   *
   * @return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the age.
   *
   * @param age
   *          the new age
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email
   *          the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

}
