package program.com.exercise01;

import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("=====RECTANGLE=====");
    float recWidth = 0;
    System.out.print("Enter long of rectangle: ");
    float recLong = Float.valueOf(sc.nextLine());
    do {
      System.out.print("Enter width of rectangle: ");
      recWidth = Float.valueOf(sc.nextLine());
      if(recLong <= recWidth) {
        System.out.println("Width <= long, try again !");
      }
    } while (recWidth >= recLong);
    Rectangle rectangle = new Rectangle(recLong, recWidth);
    System.out.println("\nRectangle width: "+rectangle.getRecWidth());
    System.out.println("Rectangle long: "+rectangle.getRecLong());
    
    System.out.println("\nPerimeter of rectangle: " + rectangle.perimeter());
    System.out.println("Area of rectangle: " + rectangle.area());

    System.out.println("\n-- Hard  set value using setter method ");
    rectangle.setRecLong(9.0f);
    rectangle.setRecWidth(5.0f);
    System.out.println("Rectangle width: "+rectangle.getRecWidth());
    System.out.println("Rectangle long: "+rectangle.getRecLong());
    System.out.println("\nPerimeter of rectangle 2: " + rectangle.perimeter());
    System.out.println("Area of rectangle 2: " + rectangle.area());

  }
}
