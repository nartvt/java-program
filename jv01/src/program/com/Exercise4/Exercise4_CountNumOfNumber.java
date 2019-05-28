package cybersoft.com.Exercise4;

import java.util.Scanner;

public class Exercise4_CountNumOfNumber {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    System.out.print("Enter Number: ");
    int number = Integer.valueOf(sc.nextLine());
    int count = 0;
    if (number == 0) {
      System.out.println("The number " + number + " has "+(count+1)+" digit ");
    } else {
      int  temp = number;
      do {
        temp = temp / 10;
        count += 1;
      } while (temp > 0);
      System.out.println("The number " + number + " has "+count+" digit ");
    }
  }
}
