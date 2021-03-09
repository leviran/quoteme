package com.shinobig.quoteme.model;

import java.util.ArrayList;
import java.util.List;

public class AllCategories {

private List<SingleCategory> allCategories;

  public AllCategories() {

    SingleCategory terror = new SingleCategory("terror");
    SingleCategory romance = new SingleCategory("romance");
    SingleCategory scifi = new SingleCategory("scifi");
    SingleCategory fantasy = new SingleCategory("fantasy");
    SingleCategory comedy = new SingleCategory("comedy");
    SingleCategory mystery = new SingleCategory("mystery");
    SingleCategory adventure = new SingleCategory("adventure");
    SingleCategory self = new SingleCategory("self");
    SingleCategory other = new SingleCategory("other");

    allCategories = new ArrayList<>();
    allCategories.add(terror);
    allCategories.add(romance);
    allCategories.add(scifi);
    allCategories.add(fantasy);
    allCategories.add(comedy);
    allCategories.add(mystery);
    allCategories.add(adventure);
    allCategories.add(self);
    allCategories.add(other);
  }

  public List<SingleCategory> getAllCategories() {
    return allCategories;
  }

  public void setAllCategories(List<SingleCategory> allCategories) {
    this.allCategories = allCategories;
  }
}
