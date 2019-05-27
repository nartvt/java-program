package program.com.exercise03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarManagement {
  private List<Car> cars;
  private Scanner sc;

  public CarManagement() {
    cars = new ArrayList<>();
    sc = new Scanner(System.in);
  }

  public List<Car> getCars() {
    return this.cars;
  }

  public void addCar(Car car) {
    this.getCars().add(car);
  }

  public void printCars() {
    this.getCars().forEach(car -> System.out.println(car.toString()));
  }

  public int isExistsCar(String carId) {
    for (int i = 0; i < this.cars.size(); i++) {
      if (cars.get(i).getCarId().equalsIgnoreCase(carId)) {
        return i;
      }
    }
    return -1;
  }

  public void updateCar(Car carAdd) {
    for (Car car : this.cars) {
      if (car.getCarId().equalsIgnoreCase(carAdd.getCarId())) {
        car.setCapacity(carAdd.getCapacity());
        car.setPriceCar(carAdd.getPriceCar());
        break;
      }
    }
  }

  public boolean deleteCar(String carId) {
    if (this.isExistsCar(carId) == -1) {
      return false;
    }
    this.getCars().remove(this.isExistsCar(carId));
    return true;
  }

  public void printTaxInfoCars() {
    this.cars.forEach(car -> {
      System.out.printf("Car ID: %s | Tax:  %.2f          |\n", car.getCarId(), car.getTax());
    });
  }

  public int menu() {
    System.out.println("\n=====Car Management Program=====");
    System.out.println("1. Add Car");
    System.out.println("2. Print all Car");
    System.out.println("3. Edit Car Info");
    System.out.println("4. Delete Car");
    System.out.println("5. Tax report for every car");
    System.out.println("6. Exit");
    System.out.print("Choose: ");
    int choose = Integer.valueOf(sc.nextLine());
    if (choose == 6) {
      return -1;
    } else if (choose != 1) {
      if (this.getCars().isEmpty()) {
        System.out.println("The List Car is Empty !");
        return 0;
      }
    }
    switch (choose) {
    case 1:
      System.out.print("Enter Car Id: ");
      String carId = sc.nextLine();
      if (isExistsCar(carId) != -1) {
        System.out.println("The Car ID has exist, Please choose other ID !");
      } else {
        Car car = new Car();
        car.setCarId(carId);
        System.out.print("Enter Car Price: ");
        car.setPriceCar(Double.valueOf(sc.nextLine()));
        System.out.print("Enter Car Capacity: ");
        car.setCapacity(Integer.valueOf(sc.nextLine()));
        car.setTax();
        this.addCar(car);
      }
      break;
    case 2:
      this.printCars();
      break;
    case 3:
      System.out.print("Enter Car Id need Edit: ");
      String carIdEdit = sc.nextLine();
      if (this.isExistsCar(carIdEdit.trim()) == -1) {
        System.out.println("This Car doesn't exists, please check again !");
      } else {
        Car carAdd = new Car();
        carAdd.setCarId(carIdEdit);
        System.out.print("Enter New Car Price: ");
        carAdd.setPriceCar(Double.valueOf(sc.nextLine()));
        System.out.print("Enter New Car Capacity: ");
        carAdd.setCapacity(Integer.valueOf(sc.nextLine()));
        this.updateCar(carAdd);
      }
      break;
    case 4:
      System.out.print("Enter Car Id need delete: ");
      String carIdDel = sc.nextLine();
      boolean isDelete = this.deleteCar(carIdDel);
      if (isDelete) {
        System.out.println("Delete Car SUCCESS !");
      } else {
        System.out.println("This Car doesn't exists, please check again !");
      }
      break;
    case 5:
      this.printTaxInfoCars();
      break;
    default:
      System.out.println("This Oprion doesn't exists, please choose again !");
      break;
    }
    return choose;
  }
}
