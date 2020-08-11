package  program.exercise17;

import java.util.Scanner;

public class TriangleShape {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    System.out.print("Enter N: ");  
    int n = Integer.valueOf(sc.nextLine());
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j);
      }
      System.out.println();
    }

  }

}
