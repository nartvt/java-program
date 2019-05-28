package cybersoft.com.Exercise15;

import java.util.Scanner;

public class Exercise15_arrayString {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    String strings = "";
    System.out.print("Enter a string: ");
    strings = sc.nextLine();
    System.out.printf("Leng of the string [%s] is: %d ", strings, strings.length());
    int index = 0;
    int length = strings.length();
    do {
      System.out.print("\n\nEnter index need to print: ");
      index = Integer.valueOf(sc.nextLine());
      if (index >= length) {
        System.out.println("Index out of string , try again !");
      }
    } while (index >= length);
    System.out.printf("Charactor of string [%s] at index %d is [%s] ", strings, index, strings.split("")[index]);

    final String subString = "abcdef";
    String[] arraysString = strings.split("");
    boolean isExists = false;
    int begin =0, end = 0;
    for (int i = 0; i < strings.length(); i++) {
      int j = i;
      j = j + subString.length();
      if (j > strings.length()) {
        break;
      } else {
        String temp = "";
        begin = i;
        for (int k = i; k < j; k++) {
          temp = temp.concat(arraysString[k]);
        }
        if (temp.equalsIgnoreCase(subString)) {
          isExists = true;
          end = j-1;
          break;
        }
      }
    }
    if (isExists) {
      System.out.printf("\nExists substring [%s] from %d to %d  in parent string [%s] ", subString,begin,end, strings);
    } else {
      System.out.printf("\nDoesn't exists [%s] in parent string [%s] ", subString,strings);
    }

    sc.close();
  }

}
