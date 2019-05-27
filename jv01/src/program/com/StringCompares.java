package cybersoft.com;

import java.util.Scanner;

public class StringCompares {
  private static Scanner sc;

  public static void main(String[] args) {
    String string_1;
    String string_2;
    sc = new Scanner(System.in);

    System.out.print("Nhap string 1: ");
    string_1 = sc.nextLine();

    System.out.print("Nhap string 2: ");
    string_2 = sc.nextLine();
    System.out.println("===========================");
    System.out.println("PHAN BIET HOA/THUONG");

    if(string_1.equals(string_2)) {
      System.out.println(">>>HAI CHUOI GIONG NHAU");
    }else {
      System.out.println(">>>HAI CHUOI KHAC NHAU");
    }
    System.out.println("===========================");
    System.out.println("KHONG PHAN BIET HOA/THUONG");
    if(string_1.equalsIgnoreCase(string_2)) {
      System.out.println(">>>HAI CHUOI GIONG NHAU");
    }else {
      System.out.println(">>>HAI CHUOI KHAC NHAU");
    }
    
    sc.close();
  }
}
