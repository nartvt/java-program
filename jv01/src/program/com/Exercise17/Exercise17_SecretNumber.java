package  program.com.Exercise17;

import java.util.Random;
import java.util.Scanner;

public class Exercise17_SecretNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    int secretNumber = rand.nextInt(1000);
    System.out.print("Choose any number: ");
    int randomNumber = Integer.valueOf(sc.nextLine());
    if (randomNumber == secretNumber) {
      System.out.println("Congratulation, the number input matcher with  secret number!");
    } else {
      if (randomNumber > secretNumber) {
        System.out.println("The number input greater secret number !");
      } else if (randomNumber < secretNumber) {
        System.out.println("The number input less secret number !");
      }
    }
  }

}
