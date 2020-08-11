package program.com.exercise02;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {
  private List<Student> students;

  public StudentClass() {
    super();
    students = new ArrayList<Student>();
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public void addStudent(final Student student) {
    this.students.add(student);
  }

  public void printAllStudents() {
    for (Student student : students) {
      System.out.println(student.toString());
    }
  }

  public void ranksAllStudents(final Rank rank) {
    System.out.println("Students " + rank.getText());
    for (Student student : students) {
      if (student.rankStudent().equalsIgnoreCase(rank.getText())) {
        System.out.println(student.toString());
      }
    }
  }

  public void studentsOverPoint(final float x) {
    for (Student student : students) {
      if (student.getMathPoint() > x || student.getPhysPoint() > x || student.getChemisPoint() > x) {
        System.out.println(student.rankStudent() + ": " + student.toString());
      }
    }
  }
}
