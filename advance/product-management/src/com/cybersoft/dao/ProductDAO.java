package com.cybersoft.dao;

import java.util.List;

import com.cybersoft.entity.Product;

public interface ProductDAO {

  List<Product> findAll();

  Product findById(int id);

  void add(Product product);

  void update(Product product);

  void delete(int id);

}
