package com.shinobig.quoteme;

import com.shinobig.quoteme.model.AllCategories;
import com.shinobig.quoteme.model.StartingDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

  private StartingDatabase startingDatabase;
  private AllCategories allCategories;
  private List<Quote> displayedQuotes;

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
      Model allCategories,
      Model displayedQuotes
  ) {
    if (theBindingResult.hasErrors()) {
      return "index";
    } else if (startingDatabase.isRightPassword(theUser.getUsername(), theUser.getPassword()) == null) {
      return "index";
    } else {
      User currentUser = startingDatabase.isRightPassword(theUser.getUsername(), theUser.getPassword());
      this.displayedQuotes = currentUser.getUserQuotes();
      testModel.addAttribute("currentUser", currentUser);
      testModel.addAttribute("addNewQuoteLink", "newQuote/form?username=" + currentUser.getUsername());
      allCategories.addAttribute("allCategories", this.allCategories);
      displayedQuotes.addAttribute("displayedQuotes", this.displayedQuotes);

      for (Quote quote : this.displayedQuotes) {
        quote.setMainColors(quote.getCategory());
      }
      return "my-quotes";
    }

  }

  @RequestMapping("/testing-user")
  public String testingUser(Model testModel, Model allCategories, Model displayedQuotes) {
    User testUser = startingDatabase.getSingleUser("Shinobi");
    this.displayedQuotes = testUser.getUserQuotes();
    testModel.addAttribute("currentUser", testUser);
    testModel.addAttribute("addNewQuoteLink", "newQuote/form?username=" + testUser.getUsername());
    allCategories.addAttribute("allCategories", this.allCategories);
    displayedQuotes.addAttribute("displayedQuotes", this.displayedQuotes);

    for (Quote quote : this.displayedQuotes) {
      quote.setMainColors(quote.getCategory());
    }


    return "my-quotes";

  }


}
