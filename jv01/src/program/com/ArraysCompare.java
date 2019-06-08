package  program.com;

import java.util.Scanner;

public class ArraysCompare {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int[] arrays = new int[10];
    // enter element for array
    System.out.println("======================\nENTER ELEMENT FOR ARRAY\n======================");
    for (int i = 0; i < arrays.length; i++) {
      System.out.printf("Enter the element %d: ", i);
      arrays[i] = Integer.valueOf(sc.nextLine());
    }
    // compare value between i and 9 - i, i from 0 to 9
    System.out.println("\n=======Comparation  value between index [i] and [9-i] ===========");
    System.out.println("INDEX(value)");
    System.out.println("==================");
    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i] == arrays[9 - i]) {
        System.out.printf("\nElement value at index %d(%d) == %d(%d)", i, arrays[i], (9 - i), arrays[9 - i]);
      } else {
        System.out.printf("\nElement value at index %d(%d) != %d(%d)", i, arrays[i], (9 - i), arrays[9 - i]);
      }
    }
  }

}
