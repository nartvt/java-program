package  program.exercise13;

import java.util.Scanner;

public class FirstLetterUpper {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);

    System.out.println("Enter String : ");
    String strings = sc.nextLine();

    String[] arrays = strings.split(" ");
    String stringAfterUpperCase = "";
    for (int i = 0; i < arrays.length; i++) {
      String temp = arrays[i].trim().substring(0, 1).toUpperCase().concat(arrays[i].trim().substring(1));
      stringAfterUpperCase += temp+" ";

    }

    System.out.println("The String after Upper case: ".toUpperCase() + stringAfterUpperCase.trim());

  }

}
