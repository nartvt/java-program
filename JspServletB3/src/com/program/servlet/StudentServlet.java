package com.program.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.program.entity.Student;

@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
  private List<Student> students = null;

  public StudentServlet() {
    students = new ArrayList<Student>();
    students.add(new Student("S001", "Tran Van A", "111111111", true, 9));
    students.add(new Student("S002", "Tran Thi Tram", "22222222", false, 5));
    students.add(new Student("S003", "Cao Ngoc Thuy", "33333", false, 8.5f));
    students.add(new Student("S004", "Nguyen Van Phi", "444444", true, 7));
    students.add(new Student("S005", "Nguyen Quang Trung", "33333", true, 4));
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("students", students);
    req.getRequestDispatcher("student.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
  }

}
