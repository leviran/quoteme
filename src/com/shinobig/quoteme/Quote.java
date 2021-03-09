package com.shinobig.quoteme;

import javax.persistence.*;

@Entity
@Table(name="quotes")
public class Quote {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;

  @Column(name="quote")
  private String quote;

  @Column(name="category")
  private String category;

  @Column(name="author")
  private String author;

  @Column(name="source")
  private String source;

  @Column(name="title")
  private String title;

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
    return super.toString();
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
}
