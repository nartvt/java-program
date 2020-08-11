package program.exercise02;

import java.util.Scanner;

public class SumExpression {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);

    System.out.print("Enter N:  ");
    int n = Integer.valueOf(sc.nextLine());

    float sumExpression = 0;
    for (int i = 1; i <= n; i++) {
      sumExpression = sumExpression + (1 / (float)(i * (i + 1) * (i + 2)));
    }
    System.out.println(sumExpression);
    sc.close();
  }

}
