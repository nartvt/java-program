package com.cybersoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.connection.JDBCConnection;
import com.cybersoft.entity.Product;

public class ProductDaoImpl implements ProductDAO {

  private static final String SQL_QUERY = "SELECT * FROM product";
  private static final String SQL_QUERY_BY_ID = SQL_QUERY.concat(" WHERE id = ?");
  private static final String SQL_QUERY_UPDATE = "UPDATE  product SET name=?, quantity=?, price =? WHERE id = ?";
  private static final String SQL_QUERY_INSERT = "INSERT INTO product(name,quantity,price) values(?,?,?)";
  private static final String SQL_QUERY_DELETE = "DELETE FROM product WHERE id = ?";

  @Override
  public List<Product> findAll() {

    List<Product> products = new ArrayList<Product>();

    try (Connection conn = JDBCConnection.getConnection()) {

      PreparedStatement statement = conn.prepareStatement(SQL_QUERY);

      ResultSet rs = statement.executeQuery();

      // verify next record has exists
      while (rs.next()) {

        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        product.setQuantity(rs.getInt("quantity"));

        products.add(product);

      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return products;
  }

  @Override
  public Product findById(int id) {

    try (Connection conn = JDBCConnection.getConnection()) {

      PreparedStatement statement = conn.prepareStatement(SQL_QUERY_BY_ID);
      statement.setInt(1, id);

      ResultSet rs = statement.executeQuery();

      Product product = new Product();
      while (rs.next()) {
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setQuantity(rs.getInt("quantity"));
        product.setPrice(rs.getFloat("price"));
      }
      return product;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void add(Product product) {

    try (Connection conn = JDBCConnection.getConnection()) {

      PreparedStatement statement = conn.prepareStatement(SQL_QUERY_INSERT);

      statement.setString(1, product.getName());
      statement.setInt(2, product.getQuantity());
      statement.setFloat(3, product.getPrice());
      statement.executeUpdate();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void update(Product product) {

    try (Connection conn = JDBCConnection.getConnection()) {

      PreparedStatement statement = conn.prepareStatement(SQL_QUERY_UPDATE);

      statement.setString(1, product.getName());
      statement.setInt(2, product.getQuantity());
      statement.setFloat(3, product.getPrice());
      statement.setInt(4, product.getId());

      statement.executeUpdate();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void delete(int id) {
    try (Connection conn = JDBCConnection.getConnection()) {

      PreparedStatement statement = conn.prepareStatement(SQL_QUERY_DELETE);
      statement.setInt(1, id);
      statement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
