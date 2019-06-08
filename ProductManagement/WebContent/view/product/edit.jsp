<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
  <h1 align="center">Edit Page</h1>
<div class="col-md-4" style="margin: 0 auto">
  <form action='<c:url value="/products/edit"/> ' method="post">
    <div class="form-group">
      <input type="hidden" name="id" class="form-control" id="id" value="${ product.id }">
    </div>
    <div class="form-group">
      <label for="Name">Name</label>
      <input type="text" name ="name"  class="form-control" id="name" value="${ product.name }">
    </div>
    <div class="form-group">
      <label for="quantity">Quantity</label>
      <input type="text" name="quantity" class="form-control" id="name" value="${ product.quantity }">
    </div>
    <div class="form-group">
      <label for="price">Price</label>
      <input type="text" name="price" class="form-control" id="price"  value="${ product.price }">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  </div>
</body>
</html>