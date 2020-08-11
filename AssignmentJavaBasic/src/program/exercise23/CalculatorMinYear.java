package  program.exercise23;

import java.util.Scanner;

public class CalculatorMinYear {

  public static void calculatorMinyear(double moneySave, float rate, double moneyDraw) {
    double moneybk = moneySave;
    int countYear = 0;
    do {
      moneybk = moneybk + (moneybk * rate);
      countYear++;
      System.out.printf("\nTotal money has in year %d is : %f",countYear, moneybk);
    } while (moneybk < moneyDraw);
    System.out.println("\nTotal year for wait: " + countYear);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Total Money Save: ");
    double moneySave = Double.valueOf(sc.nextLine());
    System.out.println("Enter Total Money Draw : ");
    double moneyDraw = Double.valueOf(sc.nextLine());
    System.out.print("Enter percent rate: ");
    float rate = Float.valueOf(sc.nextLine());
    rate = rate / 100;
    calculatorMinyear(moneySave, rate, moneyDraw);
  }

}
