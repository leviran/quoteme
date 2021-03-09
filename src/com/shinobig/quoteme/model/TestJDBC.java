package com.shinobig.quoteme.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {
  public static void main(String[] args) {
      String user = "quoteme";
      String password = "quoteme";
    try {
      System.out.println("connecting to database");
      Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/quoteme_database?useSSL=false&serverTimezone=UTC", user, password);

      System.out.println("succesfully connected to db");

    } catch (Exception e){
      e.printStackTrace();
    }
  }

}
