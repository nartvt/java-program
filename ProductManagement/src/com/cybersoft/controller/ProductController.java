package com.cybersoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.cybersoft.dao.ProductDAO;
import com.cybersoft.dao.ProductDaoImpl;
import com.cybersoft.entity.Product;

@WebServlet(urlPatterns = { "/products", "/products/edit", "/products/delete", "/products/add" })
public class ProductController extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final String PATH_VIEW_STRING = "/view/product";
  private ProductDAO productDAO = null;

  public ProductController() {
    productDAO = new ProductDaoImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String actionString = req.getServletPath();
    switch(actionString){
      case "/products":
        List<Product> products = productDAO.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher(PATH_VIEW_STRING.concat("/index.jsp")).forward(req, resp);
        break;
      case "/products/edit":
        int id = Integer.valueOf(req.getParameter("id"));
        Product product = productDAO.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher(PATH_VIEW_STRING.concat("/edit.jsp")).forward(req, resp);
        break;
      case "/products/add":
        req.getRequestDispatcher(PATH_VIEW_STRING.concat("/add.jsp")).forward(req, resp);
        break;
      case "/products/delete":
        id = Integer.valueOf(req.getParameter("id"));
        productDAO.delete(id);
        resp.sendRedirect(req.getContextPath().concat("/products"));
        break;
      default:
        break;

    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String actionString = req.getServletPath();
    int id = 0;
    String name = "";
    int quantity = 0;
    float price = 0;
    Product product = null;
    name = req.getParameter("name");
    quantity = Integer.valueOf(req.getParameter("quantity"));
    price = Float.valueOf(req.getParameter("price"));


    if (StringUtils.isBlank(req.getParameter("name"))) {
      req.setAttribute("message_name", "Name chua duoc nhap");
      if (StringUtils.isBlank(req.getParameter("quantity"))) {
        req.setAttribute("message_quantity", "Quantity chua duoc nhap");
      }
      if (StringUtils.isBlank(req.getParameter("price"))) {
        req.setAttribute("message_price", "price chua duoc nhap");
      }
      req.getRequestDispatcher(PATH_VIEW_STRING.concat("/add.jsp")).forward(req, resp);
    }

    switch(actionString){
      case "/products/edit":
        id = Integer.valueOf(req.getParameter("id"));
        name = req.getParameter("name");
        quantity = Integer.valueOf(req.getParameter("quantity"));
        price = Float.valueOf(req.getParameter("price"));
        product = new Product(id, name, quantity, price);
        productDAO.update(product);
        resp.sendRedirect(req.getContextPath().concat("/products"));
        break;
      case "/products/add":
        // id = Integer.valueOf(req.getParameter("id"));
        name = req.getParameter("name");
        quantity = Integer.valueOf(req.getParameter("quantity"));
        price = Float.valueOf(req.getParameter("price"));
        product = new Product(id, name, quantity, price);
        productDAO.add(product);
        resp.sendRedirect(req.getContextPath().concat("/products"));
        break;
      default:
        break;

    }
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String actionDeleteString = req.getServletPath();
    switch(actionDeleteString){
      case "/products/delete":
        int id = Integer.valueOf(req.getParameter("id"));
        productDAO.delete(id);
        resp.sendRedirect(req.getContextPath().concat("/products"));
        break;
      default:
        break;
    }
  }

}
