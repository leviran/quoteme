package com.shinobig.quoteme.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class AllCategories {

private List<SingleCategory> allCategories;
private LinkedHashMap<String, String> allCategoriesMap;

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

    allCategoriesMap = new LinkedHashMap<>();

    allCategoriesMap.put("terror", "Terror");
    allCategoriesMap.put("romance", "Romance");
    allCategoriesMap.put("scifi", "Science Fiction");
    allCategoriesMap.put("fantasy", "Fantasy");
    allCategoriesMap.put("comedy", "Comedy");
    allCategoriesMap.put("mystery", "Mystery");
    allCategoriesMap.put("adventure", "Adventure");
    allCategoriesMap.put("self", "Self Improvement");
    allCategoriesMap.put("other", "Other");
  }

  public List<SingleCategory> getAllCategories() {
    return allCategories;
  }

  public void setAllCategories(List<SingleCategory> allCategories) {
    this.allCategories = allCategories;
  }

  public LinkedHashMap<String, String> getAllCategoriesMap() {
    return allCategoriesMap;
  }

  public void setAllCategoriesMap(LinkedHashMap<String, String> allCategoriesMap) {
    this.allCategoriesMap = allCategoriesMap;
  }
}
