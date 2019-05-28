<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Java- Servlet B3</title>
</head>
<body>
  <div class="container">
    <h2>Student Managements</h2>
    <!--    <p>The .table class adds basic styling (light padding and horizontal dividers) to a table:</p>             -->
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>STT</th>
          <th>Student ID</th>
          <th>User Name</th>
          <th>Phone Number</th>
          <th>Gender</th>
          <th>Classification</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${ students }" var="item" varStatus="loop">
          <tr>
           <td>${ loop.index + 1 }</td>
           <td>${ item.studentId }</td>
           <td>${ item.userName }</td>
           <td>${ item.phoneNumber }</td>
           <td>
            <c:if test="${ item.gender == true }">Male</c:if>
            <c:if test="${ item.gender == false }">Female</c:if>
           </td>
           <td>
            <c:choose>
              <c:when test="${ item.averageScore < 5 }">Stupid</c:when>
              <c:when test="${ item.averageScore <= 7 }">Not Good</c:when>
              <c:when test="${ item.averageScore < 8.5 }">Good</c:when>
              <c:otherwise>Excellent</c:otherwise>
            </c:choose>
           </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>