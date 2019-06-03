package  program.com;

import java.text.ParseException;
import java.util.Scanner;

public class TimeZoneCalculator {
  private static Scanner sc;

  public static void main(String[] args) throws ParseException {
    sc = new Scanner(System.in);
    int timeZoneInput = 0;
    System.out.print("Enter TimeZone:");
    timeZoneInput = Integer.valueOf(sc.nextLine());
    convertTimeZone(timeZoneInput);
    
//  LocalTime localTime = LocalTime.now(ZoneId.of("UTC")).plusHours(timeZoneInput);
//
//  System.out.println("Now Time TimeZone: " + localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    sc.close();
  }

  private static void convertTimeZone(final int timeZone) {
    long miliSecond = System.currentTimeMillis();
    System.out.println("Current minisecond : "+miliSecond);
    
    long second = miliSecond / 1000;
    long remainSecond = second % 60;

    // convert second to minute
    long minute = second / 60;
    long remainMinute = minute % 60;

    // convert minute to hours
    long hours = minute / 60;
    long remainHours = hours % 24;
    
    System.out.println("Current time : "+(remainHours+timeZone)+":"+remainMinute+":"+remainSecond);
    
  }
}
