package cybersoft.com.Exercise6;

import java.util.Scanner;

public class Exercise6_ReserverString {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    System.out.print("Enter string: ");
    String strings = sc.nextLine();

    System.out.println("Reserver String: " + new StringBuilder(strings).reverse().toString());
  }
}
