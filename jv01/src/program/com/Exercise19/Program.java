package cybersoft.com.Exercise19;

import java.util.Scanner;

public class Program {
  private Scanner sc = new Scanner(System.in);

  public void menu() {
    int chose = 0;
    do {
      System.out.println("\n\n-----Equation resolve -----");
      System.out.println("1. ax + b = 0");
      System.out.println("2. ax^2 + bx +c = 0");
      System.out.println("3. Exit  program");
      System.out.print("Choose: ");
      chose = Integer.valueOf(sc.nextLine());
      switch (chose) {
      case 1:
        int d = equationOneHidden();
        System.out.printf("Equation value d = %d", d);
        break;
      case 2:
        quadraticEquation();
        break;
      case 3:
        System.out.println("Exis Program !");
        break;
      default:
        System.out.println("did not have this option, try another ");
        break;
      }
    } while (chose != 3);
    sc.close();

  }

  public int equationOneHidden() {
    int a = 0;
    do {
      System.out.print("Enter a: ");
      a = Integer.valueOf(sc.nextLine());
      if (a == 0) {
        System.out.println("a != 0, try enter again !");
      }
    } while (a == 0);

    System.out.print("Enter b: ");
    int b = Integer.valueOf(sc.nextLine());

    int d = ((b) * -1) / a;
    return d;
  }

  public void quadraticEquation() {
    int a = 0;
    do {
      System.out.print("Enter a: ");
      a = Integer.valueOf(sc.nextLine());
      if (a == 0) {
        System.out.println("a != 0, try enter again !");
      }
    } while (a == 0);

    System.out.print("Enter b: ");
    int b = Integer.valueOf(sc.nextLine());

    System.out.print("Enter c: ");
    int c = Integer.valueOf(sc.nextLine());
    if ((a + b + c) == 0) {
      System.out.printf("Equation has two value X1=  %d, X2 = %f ", 1, (c / a));
    }
    if ((a - b + c) == 0) {
      System.out.printf("Equation has two value X1=  %d, X2 = %f ", -1, -(c / a));
    }

    float delta = (b * b) - 4 * (a * c);
    if (delta < 0) {
      System.out.printf("This equation has no value(delta = %.2f < 0 ! ",delta);
    } else if ((int)delta == 0) {
      double x = -(b / (2 * a));
      System.out.printf("Equation has dupticate value X1 = X1 = -(b/2*a)= %.2f ! ",x);
    } else {
      double x1 = -(b) + (Math.sqrt(delta) / 2 * a);
      double x2 = -(b) - (Math.sqrt(delta) / 2 * a);
      System.out.printf("Equation has two value X1=  %.2f, X2 = %.2f ", x1, x2);
    }
  }
}
