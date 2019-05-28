package program.com.exercise02;

public class Student {
  protected String studentId;
  protected String userName;
  protected float mathPoint;
  protected float physPoint;
  protected float chemisPoint;

  public Student(String studentId, String userName, float mathPoint, float physPoint, float chemisPoint) {
    super();
    this.studentId = studentId;
    this.userName = userName;
    this.mathPoint = mathPoint;
    this.physPoint = physPoint;
    this.chemisPoint = chemisPoint;
  }

  public Student() {
    super();
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

  public float getMathPoint() {
    return mathPoint;
  }

  public void setMathPoint(float mathPoint) {
    this.mathPoint = mathPoint;
  }

  public float getPhysPoint() {
    return physPoint;
  }

  public void setPhysPoint(float physPoint) {
    this.physPoint = physPoint;
  }

  public float getChemisPoint() {
    return chemisPoint;
  }

  public void setChemisPoint(float chemisPoint) {
    this.chemisPoint = chemisPoint;
  }

  @Override
  public String toString() {
    return "Student [AVERAGE Point: " + avgPoint() + ",studentId=" + studentId + ", userName=" + userName
        + ", mathPoint=" + mathPoint + ", physPoint=" + physPoint + ", chemisPoint=" + chemisPoint + "]";
  }

  public float avgPoint() {
    return (this.mathPoint + this.physPoint + this.chemisPoint) / 3;
  }

  public String rankStudent() {
    float avg = avgPoint();
    String rank = "";
    if (avg <= 10 && avg >= 9) {
      rank = Rank.EXCELLENT.getText();
    } else if (avg >= 8) {
      rank = Rank.GOOD.getText();
    } else if (avg >= 7) {
      rank = Rank.PRETTY.getText();
    } else if (avg >= 6) {
      rank = Rank.AVERAGE.getText();
    } else if (avg < 6) {
      rank = Rank.STUPID.getText();
    }
    return rank;
  }
}
