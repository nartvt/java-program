/*
 * 
 */
package com.spring.program.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class User.
 */
@Entity(name = "Users")
public class UserEntity implements BaseEntity {

  /**
   * 
   */
  private static final long serialVersionUID = 4144571116389731638L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId")
  private long userId;

  /** The user name. */
  @Column(name = "userName")
  private String userName;

  /** The age. */
  @Column(name = "userAge")
  private int userAge;

  /** The email. */
  @Column(name = "userEmail")
  private String userEmail;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id
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
    return userAge;
  }

  /**
   * Sets the age.
   *
   * @param age
   *          the new age
   */
  public void setAge(int age) {
    this.userAge = age;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return userEmail;
  }

  /**
   * Sets the email.
   *
   * @param email
   *          the new email
   */
  public void setEmail(String email) {
    this.userEmail = email;
  }

  @Override
  public String toString() {
    return "UserEntity [id=" + this.userId + ", userName=" + userName + ", age=" + userAge + ", email=" + userEmail + "]";
  }

}
