package com.program.entity;

public class Student {
  private String studentId;
  private String userName;
  private String phoneNumber;
  private boolean gender;
  private float averageScore;

  public Student(String studentId, String userName, String phoneNumber, boolean gender, float averageScore) {
    super();
    this.studentId = studentId;
    this.userName = userName;
    this.phoneNumber = phoneNumber;
    this.gender = gender;
    this.averageScore = averageScore;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean isGender() {
    return gender;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  public float getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(float averageScore) {
    this.averageScore = averageScore;
  }

}
