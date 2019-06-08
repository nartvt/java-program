package  program.com.Exercise5;

import java.util.Scanner;

public class Exercise5_DistanceBetween2Point {
  private static Scanner sc;

  public static void main(String[] args) {
    System.out.println("=====Calculate distance between A(x1,y1),B(x2,y2)=====".toUpperCase());
    float x1, y1, x2, y2;
    sc = new Scanner(System.in);
    System.out.print("Enter X1: ");
    x1 = Float.valueOf(sc.nextLine());
    System.out.print("Enter Y1: ");
    y1 = Float.valueOf(sc.nextLine());

    System.out.print("Enter X2: ");
    x2 = Float.valueOf(sc.nextLine());
    System.out.print("Enter Y2: ");
    y2 = Float.valueOf(sc.nextLine());

    double X = Math.pow((x2 - x1), 2);
    double Y = Math.pow((y2 - y1), 2);
    double distance = Math.sqrt(X + Y);

    System.out.printf("Distance between A(%.2f,%.2f),B(%.2f,%.2f): %.2f", x1, y1, x2, y2, distance);
  }
}
