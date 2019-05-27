package com.cybersoft.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
  private static final String driverClassName = "com.mysql.jdbc.Driver";
  private static final String urlDatabase = "jdbc:mysql://localhost:3306/ProductManagement";
  private static final String userName = "root";
  private static final String password = "root";

  public static Connection getConnection() {

    try {
      Class.forName(driverClassName);
      
        return DriverManager.getConnection(urlDatabase, userName, password);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    
    return null;
  }
}
