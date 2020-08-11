package  program.exercise11;

import java.util.Scanner;

public class ReserverString {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    System.out.print("Enter string: ");
    String strings = sc.nextLine();

    System.out.println("Reserver String: " + new StringBuilder(strings).reverse().toString());
  }
}
