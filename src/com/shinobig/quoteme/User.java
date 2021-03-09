package com.shinobig.quoteme;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  private List<Quote> userQuotes;

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Quote> getUserQuotes() {
    return userQuotes;
  }

  public void setUserQuotes(List<Quote> userQuotes) {
    this.userQuotes = userQuotes;
  }

  @Override
  public String toString() {
    return super.toString();
  }

  // add convenience method for bi-directional relationship
  public void add(Quote quoteToAdd) {
    if (userQuotes == null) {
      userQuotes = new ArrayList<>();
    }
    userQuotes.add(quoteToAdd);
    quoteToAdd.setUser(this);
  }
}
