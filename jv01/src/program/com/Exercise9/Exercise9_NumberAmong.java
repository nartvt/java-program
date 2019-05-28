package cybersoft.com.Exercise9;

import java.util.Scanner;

public class Exercise9_NumberAmong {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int number_1 = 0, number_2 = 0;
    do {
      System.out.print("Enter Number 1: ");
      number_1 = Integer.valueOf(sc.nextLine());
      if (number_1 > 99 || number_1 < 10) {
        System.out.println("Number only between 10 and 99, try again ! ");
      }
    } while (number_1 > 99 || number_1 < 10);

    do {
      System.out.print("Enter Number 2: ");
      number_2 = Integer.valueOf(sc.nextLine());
      if (number_2 > 99 || number_2 < 10) {
        System.out.println("Number only between 10 and 99, try again ! ");
      }
    } while (number_2 > 99 || number_2 < 10);
    String[] numbers1 = (number_1 + "").split("");
    String[] numbers2 = (number_2 + "").split("");
    boolean isContain = false;
    for (int i = 0; i < numbers1.length; i++) {
      for (int j = 0; j < numbers1.length; j++) {
        if (numbers1[i].equals(numbers2[j])) {
          isContain = true;
          break;
        }
        if (isContain)
          break;
      }
    }
    System.out.printf("(%d,%d) =>%B", number_1, number_2, isContain);
  }

}
