package  program.com.Exercise1;

public class Exercise1_AmericaFlag {

  private static final int width = 15;
  private static final int heigh = 50;

  public static void main(String[] args) {
    for (int i = 1; i <= width; i++) {
      for (int j = 1; j <= heigh; j++) {
        if (i <= 9 && j <= 12) {
          if (i % 2 == 1 && j % 2 == 1) {
            System.out.print("*");
          } else if (i % 2 == 1 && j % 2 == 0) {
            System.out.print(" ");
          } else if (i % 2 == 0 && j % 2 == 1) {
            System.out.print(" ");
          } else if (i % 2 == 0 && j % 2 == 0) {
            if (j == 12) {
              System.out.print(" ");
            } else {
              System.out.print("*");
            }
          }
        } else {
          System.out.print("=");
        }
      }
      // break current line and down to next  line
      System.out.println();
    }
  }

}
