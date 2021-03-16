package com.shinobig.quoteme;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "id")
  private int id;

  @NotNull
  @Size(min = 1, message = "Username is required")
  @Column(name = "username")
  private String username;

  @NotNull
  @Size(min = 1, message = "Password is required")
  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
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

  public List<Quote> filterQuotes(String category){
    List<Quote> filteredList = new ArrayList<>();

    if(category.equals("all")){
      return this.userQuotes;
    } else {
      for(Quote quote : this.userQuotes){
        if(quote.getCategory().equals(category)){
          filteredList.add(quote);
        }
      }
      return filteredList;
    }
  }

  public Quote getSingleQuote(int id){
    for(Quote quote : this.userQuotes){
      if(quote.getId() == id){
        return quote;
      }
    }
    return null;
  }

  public void editQuote(Quote newValues, int quoteId){
    Quote quoteToEdit = getSingleQuote(quoteId);
    quoteToEdit.setQuote(newValues.getQuote());
    quoteToEdit.setAuthor(newValues.getAuthor());
    quoteToEdit.setSource(newValues.getSource());
    quoteToEdit.setCategory(newValues.getCategory());
  }
}
