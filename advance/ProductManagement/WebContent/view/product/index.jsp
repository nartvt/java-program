<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Product Managements</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
  <h1 align="center">Product Managements</h1>
  <div class="container-fluid">
<div class="row">
      <div class="col-md-12">
       <a href='<c:url value="/products/add"/>' class="btn btn-primary" id  ="btn__add">ADD</a>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>INDEX</th>
          <th>Product Name</th>
          <th>Quantity</th>
          <th>Price</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${ products }" var="item" varStatus="loop">
          <tr>
            <td>${ item.id }</td>
            <td>${ item.name }</td>
            <td>${ item.quantity }</td>
            <td>${ item.price }</td>
            <td id="btn__action">
             
              <a href='<c:url value="/products/edit?id="/>${ item.id }' class="btn btn-warning" id="btn__edit">EDIT</a>
              <a href='<c:url value="/products/delete?id=" />${item.id }' class="btn btn-danger" id="btn__delete">DELETE</a>
            </td>
          </tr>
        </c:forEach>
        <tr>

        </tr>
      </tbody>
    </table>
  </div>
  </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!--   <script src="./view/product/js/main.js"></script> -->
</body>
</html>
