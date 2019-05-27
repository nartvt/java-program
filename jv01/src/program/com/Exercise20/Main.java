package cybersoft.com.Exercise20;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Enter size of arrays: ");
    int n = Integer.valueOf(sc.nextLine());
    int[] array = new int[n];
    int evenNumber = 0;
    int oddNumber = 0;
    for (int i = 0; i < n; i++) {
      System.out.printf("array[%d]: ", i);
      int number = Integer.valueOf(sc.nextLine());
      if (number % 2 == 0) {
        evenNumber++;
      } else {
        oddNumber++;
      }
      array[i] = number;
    }
    System.out.print(Arrays.toString(array));
    // seperate array
    int[] evenArray = null;
    int[] oddArray = null;
    if (evenNumber == 0) {
      System.out.println("\nArray did not even number !");
    } else {
      evenArray = new int[evenNumber];
    }
    if (oddNumber == 0) {
      System.out.println("\nArray did not odd number !");
    } else {
      oddArray = new int[oddNumber];
    }
    if (evenArray != null || oddArray != null) {
      int j = 0, k = 0;
      for (int i = 0; i < n; i++) {
        if (array[i] % 2 == 0) {
          evenArray[j] = array[i];
          j++;
        } else {
          oddArray[k] = array[i];
          k++;
        }
      }
      if(j>0) {
        System.out.println("\nEven number of array: "+Arrays.toString(evenArray));
      }
      if(k>0) {
        System.out.println("\nOdd number of array: "+Arrays.toString(oddArray));
      }
    }

  }
}
