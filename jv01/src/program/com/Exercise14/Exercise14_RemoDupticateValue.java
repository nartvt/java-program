package  program.com.Exercise14;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise14_RemoDupticateValue {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Enter size of arrays: ");
    int n = Integer.valueOf(sc.nextLine());
    int[] arrays = new int[n];
    for (int i = 0; i < arrays.length; i++) {
      System.out.printf("a[%d]:", i);
      arrays[i] = Integer.valueOf(sc.nextLine());
    }
    arrays = removeDupticate(arrays);
    System.out.println(Arrays.toString(arrays));
    sc.close();
  }

  public static int[] removeDupticate(int[] arrays) {
    Arrays.sort(arrays);
    int[] temp = new int[arrays.length];
    int count = 0;
    for (int i = 0; i < arrays.length - 1; i++) {
      if (arrays[i] != arrays[i + 1]) {
        temp[count++] = arrays[i];
      } else {
        temp[count++] = Integer.MAX_VALUE;
      }

    }
    temp[count++] = arrays[arrays.length - 1];
    int n = 0;
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] != Integer.MAX_VALUE) {
        n++;
      }
    }

    int[] absoluteArrays = new int[n];
    n = 0;
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] != Integer.MAX_VALUE) {
        absoluteArrays[n] = temp[i];
        n++;
      }
    }
    return absoluteArrays;
  }
}
