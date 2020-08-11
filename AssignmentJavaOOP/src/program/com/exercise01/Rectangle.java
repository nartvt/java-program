package program.com.exercise01;

public class Rectangle {
  private float recLong;
  private float recWidth;

  public Rectangle(float recLong, float recWidth) {
    super();
    this.recLong = recLong;
    this.recWidth = recWidth;
  }

  public float getRecLong() {
    return recLong;
  }

  public void setRecLong(float recLong) {
    this.recLong = recLong;
  }

  public float getRecWidth() {
    return recWidth;
  }

  public void setRecWidth(float recWidth) {
    this.recWidth = recWidth;
  }

  public double perimeter() {
    return (this.recLong + this.recWidth) * 2;
  }

  public double area() {
    return (this.recLong * this.recWidth);
  }

}
