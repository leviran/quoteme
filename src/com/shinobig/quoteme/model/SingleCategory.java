package com.shinobig.quoteme.model;

public class SingleCategory {

  private String categoryName;
  private String categoryLink;
  private String testLink;
  private String categoryColor;
  private String icon;

  public SingleCategory(String categoryName) {
    this.categoryName = categoryName;
    this.testLink = "testing-user/" + categoryName;
    this.categoryLink = "?category=" + categoryName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCategoryLink() {
    return categoryLink;
  }

  public void setCategoryLink(String categoryLink) {
    this.categoryLink = categoryLink;
  }

  public String getCategoryColor() {
    return categoryColor;
  }

  public void setCategoryColor(String categoryColor) {
    this.categoryColor = categoryColor;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getTestLink() {
    return testLink;
  }

  public void setTestLink(String testLink) {
    this.testLink = testLink;
  }
}
