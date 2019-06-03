package  program.com;

import java.util.Scanner;

public class KaraokeCalculator {
  private static Scanner sc;
  private static final int bottleWaterPrice = 10000;

  private static final int priceFirstThreeHours = 30000;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int beginHours = 0, endHours = 0, bottleWaterUse = 0;
    double totalBill = 0.0;
    // =====INPUT VALUE BLOCK====
    // input value for begin and end hours
    System.out.println("Karaoke Bar begin at 9:00 and end at 24:00\n");
    // INPUT BEGIN HOURS
    do {

      System.out.print("Enter begin hours: ");
      beginHours = Integer.valueOf(sc.nextLine());

      if (beginHours < 9 && beginHours > 24) {
        System.out.println("fail, begin hours(>= 9:00 and <=24:00: ");
      }
    } while (beginHours < 9 || beginHours > 24);
    // INPUT END HOURS
    do {
      System.out.print("Enter end hours: ");
      endHours = Integer.valueOf(sc.nextLine());

      if (endHours < 9 && endHours > 24 && endHours < beginHours) {
        System.out.println("fail, end hours mandatory >= 9:00 and <=24:00 and greater beginHours");
      }
    } while (endHours < 9 || endHours > 24 || endHours < beginHours);

    do {
      System.out.print("Enter total bottle water used: ");
      bottleWaterUse = Integer.valueOf(sc.nextLine());

      if (bottleWaterUse < 0) {
        System.out.println("fail, bottleWater mandatory >= 0");
      }
    } while (bottleWaterUse < 0);

    // ====CALCULATOR BLOCK====
    int totalHours = endHours - beginHours;
    if (totalHours == 0) {
      System.out.println("NOT INTO TO BAR");
    } else {
      if (totalHours <= 3) {
        totalBill = priceFirstThreeHours * totalHours + (bottleWaterPrice * bottleWaterUse);
      } else {

        totalBill = priceFirstThreeHours * 3;
        int temp = totalHours - 3;

        do {
          totalBill = totalHours + (priceFirstThreeHours * 0.7) * 1;
          temp = temp - 1;
        } while (temp > 0);
        totalBill = totalHours + (bottleWaterPrice * bottleWaterUse);
      }

    }
    //=====OUTPUT RESULT
    System.out.println("=====TOTAL BILL=====");
    System.out.println("Begin Hours: " + beginHours);
    System.out.println("End Hours: " + endHours);
    System.out.println("Total Bottle Water use: " + bottleWaterUse);
    System.out.println("Total Bill: " + totalBill);
    if (beginHours <= 17 && beginHours >= 9) {
      totalBill = totalBill - (totalBill * 0.2);
      System.out.println("Total bill for pay(after discount 20% because into to Bar in between  (9:00 - 17:00): "+totalBill);
    }
    sc.close();
  }

}
