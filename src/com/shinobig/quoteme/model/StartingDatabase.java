package com.shinobig.quoteme.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.JDBC;

public class StartingDatabase {

  private Connection conn;
  private String dbName;

  public StartingDatabase(){
    open();
  }

  public StartingDatabase(String dbName) {
    this.dbName = dbName;
    open();
  }

  public boolean open(){
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection(dbName);
      System.out.println("Successfully connected to DB");


      Statement statement = conn.createStatement();
//      statement.execute("CREATE TABLE users (_id INTEGER, username STRING, password STRING)");
//      statement.execute("CREATE TABLE quotes (_id INTEGER, userid INTEGER, category STRING, quote STRING, author STRING, source STRING)");
     // statement.execute("INSERT INTO users (_id, username, password) VALUES (0 ,'shinobi', 'megatonto1')");
//INSERT INTO quotes (_id, userid, category, quote, author, source) VALUES (0, 0 ,'romance', 'La peor forma de extrañar a alguien es estar sentado a su lado y saber que nunca lo podrás tener', 'Gabriel García Márquez', 'unknown');
//INSERT INTO quotes (_id, userid, category, quote, author, source) VALUES (1, 0 ,'terror', 'And the Raven, never flitting, still is sitting, still is sitting On the pallid bust of Pallas just above my chamber door', 'Edgar Allan Poe', 'The raven');
//INSERT INTO quotes (_id, userid, category, quote, author, source) VALUES (1, 0 ,'terror', 'And the Raven, never flitting, still is sitting, still is sitting On the pallid bust of Pallas just above my chamber door', 'Edgar Allan Poe', 'The raven');
//INSERT INTO quotes (_id, userid, category, quote, author, source) VALUES (2, 0 ,'scifi', 'ay the Force be with you', 'Obi Wan Kenobi', 'Star Wars');
//INSERT INTO quotes (_id, userid, category, quote, author, source) VALUES (2, 0 ,'scifi', 'ay the Force be with you', 'Obi Wan Kenobi', 'Star Wars');




      // terror
      // romance
      // scifi
      // fantasy
      // comedy
      // mystery
      // adventure
      // self
      // other


      return true;

    } catch (SQLException e){
      System.out.println(e.getMessage());
      return false;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return false;
    }
  }

  public Connection getConn() {
    return conn;
  }

  public void setConn(Connection conn) {
    this.conn = conn;
  }

  public String getDbName() {
    return dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }
}
