package com.shinobig.quoteme;

import com.shinobig.quoteme.model.AllCategories;
import com.shinobig.quoteme.model.StartingDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

  StartingDatabase startingDatabase;
  AllCategories allCategories;

  public HomeController() {
  }

  public HomeController(StartingDatabase startingDatabase) {
    this.startingDatabase = startingDatabase;
  }

  public HomeController(StartingDatabase startingDatabase, AllCategories allCategories) {
    this.startingDatabase = startingDatabase;
    this.allCategories = allCategories;
  }

  @RequestMapping("/")
  public String showMainPage(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "index";
  }

  @RequestMapping("/myQuotes")
  public String myQuotes(
      @Valid @ModelAttribute("user")
          User theUser,
      BindingResult theBindingResult,
      Model testModel,
      Model allCategories
  ) {
    if (theBindingResult.hasErrors()) {
      return "index";
    } else if (startingDatabase.isRightPassword(theUser.getUsername(), theUser.getPassword()) == null) {
      return "index";
    } else {
      User currentUser = startingDatabase.isRightPassword(theUser.getUsername(), theUser.getPassword());
      testModel.addAttribute("currentUser", currentUser);
      allCategories.addAttribute("allCategories", this.allCategories);
      return "my-quotes";
    }

  }

  @RequestMapping("/testing-user")
  public String testingUser(Model testModel, Model allCategories){
    User testUser = startingDatabase.getSingleUser("Shinobi");
    testModel.addAttribute("currentUser", testUser);
    allCategories.addAttribute("allCategories", this.allCategories);

    return "my-quotes";

  }


}
