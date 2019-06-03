package  program.com;

import java.util.Scanner;

public class SortNumber {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    System.out.println("Generalization : n number ");
    int n = 0;
    int[] arrays;
    System.out.println("Enter size of arrays: ");
    n = Integer.valueOf(sc.nextLine());
    arrays = new int[n];
    inputArrays(n, arrays);
    System.out.println();
    printfArrays(arrays);
    System.out.println("\nValidate arrays sort: ");
    if (isAssending(arrays)) {
      System.out.println("Array Assending !");
    } else {
      if (isDesending(arrays)) {
        System.out.println("Array Desending !");
      } else {
        System.out.println("Array unsort !");
      }
    }

  }

  private static void inputArrays(final int n, final int[] arrays) {
    for (int i = 0; i < arrays.length; i++) {
      System.out.printf("arrays[%d]: ", i);
      arrays[i] = Integer.valueOf(sc.nextLine());
    }
  }

  private static void printfArrays(final int[] arrays) {
    for (int i = 0; i < arrays.length; i++) {
      System.out.printf("%d ", arrays[i]);
    }
  }

  private static boolean isAssending(final int[] arrays) {
    int max = arrays[0];
    boolean isSorted = true;
    for (int i = 1; i < arrays.length; i++) {
      if (max < arrays[i]) {
        isSorted = false;
      }
    }
    return isSorted;
  }

  private static boolean isDesending(final int[] arrays) {
    int min = arrays[0];
    boolean isSorted = true;
    for (int i = 1; i < arrays.length; i++) {
      if (min > arrays[i]) {
        isSorted = false;
      }
    }
    return isSorted;
  }
}
