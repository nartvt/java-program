package  program.exercise07;

public class ConvertDecimalToBinary {

  private static String convertDectoBin(final int decimalNumber) {
    String binaryNumber = "";
    if (decimalNumber == 0) {
      binaryNumber = "0";
    } else {
      int temp = decimalNumber;
      do {
        int remainder = temp % 2;
        binaryNumber += remainder;
        temp = temp / 2;
      } while (temp != 0);
    }
    return new StringBuilder(binaryNumber).reverse().toString();
  }

  private static int convertBinToDec(final String binaryNumber) {
    int decimalNumber = 0;
    if (binaryNumber.equals("0") || binaryNumber.equals("1")) {
      return Integer.valueOf(binaryNumber);
    } else {
      String[] arrays = binaryNumber.split("");
      for (int i = 0; i < arrays.length; i++) {
        int temp = Integer.valueOf(arrays[i]);
        if (temp == 0) {
          decimalNumber += 0;
        } else {
          decimalNumber += Math.pow(2, arrays.length - i - 1);
        }
      }
    }
    return decimalNumber;
  }

  public static void main(String[] args) {
    System.out.println("=====PROGRAM CONVERT DECIMAL TO BINARY NUMBER===");
    System.out.println("55 = " + convertDectoBin(200));
    System.out.println("=====PROGRAM CONVERT BINARY TO DECIMAL NUMBER===");
    System.out.println("110111 = " + convertBinToDec("110111"));
  }
}
