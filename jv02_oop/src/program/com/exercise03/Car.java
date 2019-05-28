package program.com.exercise03;

import java.text.NumberFormat;

public class Car {
  protected String carId;
  protected double priceCar;
  protected int capacity;
  protected double tax;

  public Car(String carId, double priceCar, int capacity) {
    super();
    this.carId = carId;
    this.priceCar = priceCar;
    this.capacity = capacity;
    this.setTax();

  }

  public void setTax() {
    if (this.capacity > 200) {
      this.tax = this.priceCar * 0.05;
    } else if (this.capacity >= 100 && this.capacity <= 200) {
      this.tax = this.priceCar * 0.03;
    } else {
      // < 100 cc
      this.tax = this.priceCar * 0.01;
    }
  }

  public String getCarId() {
    return carId;
  }

  public void setCarId(String carId) {
    this.carId = carId;
  }

  public double getTax() {
    return this.tax;
  }

  public Car() {
    super();
  }

  public double getPriceCar() {
    return priceCar;
  }

  public void setPriceCar(double priceCar) {
    this.priceCar = priceCar;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  @Override
  public String toString() {
    return "Car [carId=" + carId + ", priceCar=" + String.format("%.2f", priceCar) + ", capacity=" + capacity + ", tax="
        + String.format("%.2f", tax) + "]";
  }
}
