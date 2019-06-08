package  program.com.Exercise16;

import java.util.Scanner;

public class Exercise16_calculatorLeapYear {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a Year: ");
    int y = Integer.valueOf(sc.nextLine());
    if(y%400 == 0 || (y%4==0 && y % 100 ==0)) {
      System.out.println("Leap Year !");
    }else {
      System.out.println("Normal Year !");
    }
  }

}
