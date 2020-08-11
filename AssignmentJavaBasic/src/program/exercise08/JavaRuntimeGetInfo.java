package  program.exercise08;

public class JavaRuntimeGetInfo {

  public static void main(String[] args) {
    String java_version = System.getProperty("java.version");
    String java_runtime_version = System.getProperty("java.runtime.version");
    String java_home = System.getProperty("java.home");
    String java_vendor = System.getProperty("java.vendor");
    String java_vendor_url = System.getProperty("java.vendor.url");
    String java_class_path = System.getProperty("java.class.path");
    System.out.println("Java Version: " + java_version);
    System.out.println("Java Runtime Version: " + java_runtime_version);
    System.out.println("Java Home: " + java_home);
    System.out.println("Java Vendor: " + java_vendor);
    System.out.println("Java Vendor URL: " + java_vendor_url);
    System.out.println("Java Class Path: " + java_class_path);
  }

}
