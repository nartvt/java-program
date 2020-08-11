package program.com.exercise02;

public class Program {
  public static void main(String[] args) {
    Student student01 = new Student("S001", "Tran Van A", 9, 10, 8);
    Student student02 = new Student("S002", "Tran Van B", 8, 7, 6);
    Student student03 = new Student("S003", "Tran Van C", 5, 4, 3);
    Student student04 = new Student("S004", "Tran Van E", 7, 7, 7);
    Student student05 = new Student("S005", "Tran Van F", 9, 1, 8);
    Student student06 = new Student("S006", "Tran Van G", 2, 3, 10);
    Student student07 = new Student("S007", "Tran Van H", 9, 10, 8);
    Student student08 = new Student("S008", "Tran Van I", 7, 10, 8);
    Student student09 = new Student("S009", "Tran Van J", 2, 9, 10);
    Student student10 = new Student("S010", "Tran Van K", 9, 5, 6);

    StudentClass studentClass = new StudentClass();
    studentClass.addStudent(student01);
    studentClass.addStudent(student04);
    studentClass.addStudent(student02);
    studentClass.addStudent(student03);
    studentClass.addStudent(student05);
    studentClass.addStudent(student06);
    studentClass.addStudent(student07);
    studentClass.addStudent(student08);
    studentClass.addStudent(student09);
    studentClass.addStudent(student10);

    System.out.println("All of Student of the class: ");
    studentClass.printAllStudents();
    System.out.println("==============================================================================");
    System.out.println("\nAll of Student of the class with Excellent rank:  ".toUpperCase());
    studentClass.ranksAllStudents(Rank.EXCELLENT);
    System.out.println("==============================================================================");
    System.out.println("\nAll of Student of the class with Good rank:  ".toUpperCase());
    studentClass.ranksAllStudents(Rank.GOOD);
    System.out.println("==============================================================================");
    System.out.println("\nAll of Student of the class with PRETTY rank:  ".toUpperCase());
    studentClass.ranksAllStudents(Rank.PRETTY);
    System.out.println("==============================================================================");
    System.out.println("\nAll of Student of the class with AVERAGE rank:  ".toUpperCase());
    studentClass.ranksAllStudents(Rank.AVERAGE);
    System.out.println("==============================================================================");
    System.out.println("\nAll of Student of the class with STUPID rank:  ".toUpperCase());
    studentClass.ranksAllStudents(Rank.STUPID);
    System.out.println("==============================================================================");
    int x = 8;
    System.out
        .println("\nAll of Student of the class with point Math or Physical or chemistry over:  ".toUpperCase() + x);
    studentClass.studentsOverPoint(x);

  }
}
