package  program.exercise16;

import java.util.Scanner;

public class LogaritProgram {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    System.out.print("Enter N: ");
    int n = Integer.valueOf(sc.nextLine());
    double logaritValue = Math.log(n) / Math.log(2);
    int i = 1;
    for (; i < ((int) logaritValue); i++)
      ;
    System.out.printf("%d is natural number biggest and less log%d(%d) = %f", i, 2, n, logaritValue);
  }
}
