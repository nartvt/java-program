package program.com.exercise04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
  // final for one time define and assign to ArrayList<>();
  // not effect to any execute method : add, remove, get....
  private final List<Bus> bustList;
  private Scanner sc;

  public Company() {

    bustList = new ArrayList<Bus>();
    sc = new Scanner(System.in);
  }

  public void menu() {
    int option = 0;
    do {

      System.out.println("\n===== Bus Management Program =====");
      System.out.println("1. Add a Bus");
      System.out.println("2. Print Bus List");
      System.out.println("3. Total revenue for Bus In City");
      System.out.println("4. Total revenue for Bus Out City");
      System.out.println("5. Total revenue for all of Bus");
      System.out.println("6. Exit Program");
      System.out.print("Choose: ");
      option = Integer.valueOf(sc.nextLine());
      if (option == 6) {
        System.out.println("Bus Management Program End ");
      } else if (option != 1 && this.getBustList().isEmpty()) {
        System.out.println("The List bus is Empty, Please Input a least bus !");
      } else {
        optionProgram(option);
      }
    } while (option != 6);
  }

  private void optionProgram(int option) {
    switch (option) {
    case 1:
      int temp = 0;
      Bus bus = null;
      do {
        temp = this.subMenu(bus);
        if (temp == 3) {
          System.out.println("Input Bus End ");
        }
      } while (temp != 3);
      break;
    case 2:
      this.printfAllBusList();
      break;
    case 3:
      double totalRevenueBusInCity = this.revenueBusInCity();
      System.out.print("Total revenue of Bus In City:  " + String.format("%.2f", totalRevenueBusInCity));
      break;
    case 4:
      double totalRevenueBusOutCity = this.revenueBusOutCity();
      System.out.print("Total revenue of Bus In City:  " + String.format("%.2f", totalRevenueBusOutCity));
      break;
    case 5:
      double totalRevenue = this.revenueAllBus();
      System.out.print("Total revenue of Bus In City:  " + String.format("%.2f", totalRevenue));
      break;
    default:
      System.out.println("This option doesn't exist, please try another option !");
      break;
    }
  }

  private void inputInfoBus(Bus bus) {
    String busIdAdd = "";
    boolean isBusIdAdd = false;
    do {
      System.out.print("Enter bus Id: ");
      busIdAdd = sc.nextLine();
      if (this.isExists(busIdAdd)) {
        System.out.println("This Bus is has exist, please enter other ID !");
      } else {
        isBusIdAdd = true;
      }
    } while (!isBusIdAdd);
    System.out.print("Enter user name of driver: ");
    String userNameDriver = sc.nextLine();
    System.out.print("Enter number code of bus: ");
    String busNumber = sc.nextLine();
    bus.setBusId(busIdAdd);
    bus.setUserName(userNameDriver);
    bus.setBusNumber(busNumber);
  }

  private int subMenu(Bus bus) {
    int option = 0;
    System.out.println("=================");
    System.out.println("1. Bus In City ");
    System.out.println("2. Bus Out City");
    System.out.println("3. Exit Program");
    System.out.print("Choose: ");
    option = Integer.valueOf(sc.nextLine());
    if (option == 3) {
      return option;
    }
    switch (option) {
    case 1:
      bus = new BusInCity();
      inputInfoBus(bus);
      System.out.print("Enter route of Bus:  ");
      String routeWay = sc.nextLine();
      System.out.print("Enter total KM of route: ");
      int totalKM = Integer.valueOf(sc.nextLine());
      ((BusInCity) bus).setRouteWay(routeWay);
      ((BusInCity) bus).setTotalKM(totalKM);
      this.getBustList().add(bus);
      break;
    case 2:
      bus = new BusOutCity();
      inputInfoBus(bus);
      System.out.print("Enter Destination of Bus:  ");
      String busDestination = sc.nextLine();
      System.out.print("Enter day Of Use Bus: ");
      int dayOfUseBus = Integer.valueOf(sc.nextLine());
      ((BusOutCity) bus).setBusDestination(busDestination);
      ((BusOutCity) bus).setDayOfUseBus(dayOfUseBus);
      this.getBustList().add(bus);
      break;
    default:
      System.out.println("This option doesn't exist, please try another option !");
      break;
    }
    return option;
  }

  public List<Bus> getBustList() {
    return bustList;
  }

  private int getIndexBus(String busId) {
    for (int i = 0; i < bustList.size(); i++) {
      if (bustList.get(i).getBusId().equalsIgnoreCase(busId)) {
        return i;
      }
    }
    return -1;
  }

  private boolean isExists(String busId) {
    int index = this.getIndexBus(busId);
    return (index == -1) ? false : true;
  }

  private boolean addBus(Bus bus) {
    return this.getBustList().add(bus);
  }

  private void printfAllBusList() {
    this.getBustList().forEach(System.out::println);
  }

  private double revenueBusOutCity() {
    double totalMoneyRevenue = 0;
    for (Bus bus : this.bustList) {
      if (bus instanceof BusOutCity) {
        totalMoneyRevenue += bus.revenue();
      }
    }
    return totalMoneyRevenue;
  }

  private double revenueBusInCity() {
    double totalMoneyRevenue = 0;
    for (Bus bus : this.bustList) {
      if (bus instanceof BusInCity) {
        totalMoneyRevenue += bus.revenue();
      }
    }
    return totalMoneyRevenue;
  }

  private double revenueAllBus() {
    double totalMoneyRevenue = 0;
    for (Bus bus : this.bustList) {
      totalMoneyRevenue += bus.revenue();
    }
    return totalMoneyRevenue;
  }
}
