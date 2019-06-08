package  program.com.Exercise7;

import java.util.Scanner;

public class Exercise7_DivisorOfNaturalNumber {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    System.out.println("Enter a Number: ");
    int number = Integer.valueOf(sc.nextLine());
    if (number == 0) {
      System.out.println("Zero doesn't have any divisor");
    } else {
      for (int i = 1; i <= (number / 2); i++) {
        if (number % i == 0) {
          System.out.print(i + " ");
        }
      }
    }
  }

}
