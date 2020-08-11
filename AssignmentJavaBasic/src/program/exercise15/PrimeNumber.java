package  program.exercise15;

import java.util.Scanner;

public class PrimeNumber {
  private static Scanner sc;

  private static boolean isPrime(final int number) {
    if (number < 2) {
      return false;
    }
    boolean isPrimeNuber = true;
    for (int i = 2; i <= (number / 2); i++) {
      if (number % i == 0) {
        isPrimeNuber = false;
      }
    }
    return isPrimeNuber;
  }

  public static void main(String[] args) {
   
    sc = new Scanner(System.in);
    System.out.print("Enter N: ");
    int number = Integer.valueOf(sc.nextLine());
    if (number < 2) {
      System.out.println("doesn't have any prime number less !" + number);
    } else {
      int totalPrime = 0;
      for (int i = 2; i <= (number / 2); i++) {
        if (isPrime(i)) {
          totalPrime += i;
          System.out.print(i + "  ");
        }
      }
      System.out.printf("\nTotal prime number from 1 to %d: %d",number,totalPrime);
    }
  }

}
