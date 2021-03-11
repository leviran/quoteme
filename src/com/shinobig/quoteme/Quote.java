package com.shinobig.quoteme;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="quotes")
public class Quote {



  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;

  @NotNull
  @Size(min = 1, message = "Password is required")
  @Column(name="quote")
  private String quote;

  @NotNull
  @Size(min = 1, message = "Password is required")
  @Column(name="category")
  private String category;


  @NotNull
  @Size(min = 1, message = "Password is required")
  @Column(name="author")
  private String author;

  @NotNull
  @Size(min = 1, message = "Password is required")
  @Column(name="source")
  private String source;

  @NotNull
  @Size(min = 1, message = "Password is required")
  @Column(name="title")
  private String title;

  @Transient
  private String backgroundColor;

  @Transient
  private String mainColor;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name="user_id")
  private User user;

  public Quote() {
  }

  public Quote(String quote, String category, String author, String source, String title) {
    this.quote = quote;
    this.category = category;
    this.author = author;
    this.source = source;
    this.title = title;

  }

  @Override
  public String toString() {
    return this.quote;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getQuote() {
    return quote;
  }

  public void setQuote(String quote) {
    this.quote = quote;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getBackgroundColor() {
    return backgroundColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  public String getMainColor() {
    return mainColor;
  }

  public void setMainColor(String mainColor) {
    this.mainColor = mainColor;
  }

  public void setMainColors(String category){
    switch(category) {
      case "horror":
        this.mainColor = "#4527a0";
        this.backgroundColor = "#d1c4e9";
        break;
      case "romance":
        this.mainColor = "#e53935";
        this.backgroundColor = "#ffcdd2";
        break;
      case "scifi":
        this.mainColor = "#0d47a1";
        this.backgroundColor = "#bbdefb";
        break;
      case "fantasy":
        this.mainColor = "#2e7d32";
        this.backgroundColor = "#c8e6c9";
        break;
      case "comedy":
        this.mainColor = "#e65100";
        this.backgroundColor = "#ffe0b2";
        break;
      case "mystery":
        this.mainColor = "#424242";
        this.backgroundColor = "#eeeeee";
        break;
      case "adventure":
        this.mainColor = "#00695c";
        this.backgroundColor = "#b2dfdb";
        break;
      case "self":
        this.mainColor = "#ad1457";
        this.backgroundColor = "#fce4ec";
        break;
      default:
        this.mainColor = "#6d4c41";
        this.backgroundColor = "#d7ccc8";
    }
  }
}
