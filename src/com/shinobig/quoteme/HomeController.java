package com.shinobig.quoteme;

import com.shinobig.quoteme.model.AllCategories;
import com.shinobig.quoteme.model.StartingDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
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
      @RequestParam(value = "category", required = false) String category,
      @Valid @ModelAttribute("user")
          User theUser,
      BindingResult theBindingResult,
      Model testModel,
      Model allCategories,
      Model displayedQuotes
  ) {

    String fixedCategory;

    if(category == null){
      fixedCategory = "all";
    } else {
      fixedCategory = category;
    }

    if (theBindingResult.hasErrors()) {
      return "index";
    } else if (startingDatabase.isRightPassword(theUser.getUsername(), theUser.getPassword()) == null) {
      return "index";
    } else {
      User currentUser = startingDatabase.isRightPassword(theUser.getUsername(), theUser.getPassword());
      if(currentUser.getUserQuotes().size() > 0){

        this.displayedQuotes = currentUser.filterQuotes(fixedCategory);
      } else {
        this.displayedQuotes = new ArrayList<>();
      }

      testModel.addAttribute("currentUser", currentUser);
      testModel.addAttribute("addNewQuoteLink", "newQuote/form?username=" + currentUser.getUsername() + "&quoteid=" + 0);
      allCategories.addAttribute("allCategories", this.allCategories);
      displayedQuotes.addAttribute("displayedQuotes", this.displayedQuotes);


      for (Quote quote : this.displayedQuotes) {
        quote.setMainColors(quote.getCategory());
        String editQuoteLink = "newQuote/form?username=" + currentUser.getUsername() + "&quoteid=" + quote.getId();
        quote.setEditQuoteLink(editQuoteLink);
      }
      return "my-quotes";
    }

  }

  @RequestMapping(value = "/testing-user", method = RequestMethod.GET)
  public String testingUser(@RequestParam("category") String category, Model testModel, Model allCategories, Model displayedQuotes) {

    User testUser = startingDatabase.getSingleUser("Shinobi");
    this.displayedQuotes = testUser.filterQuotes(category);
    testModel.addAttribute("currentUser", testUser);
    testModel.addAttribute("addNewQuoteLink", "newQuote/form?username=" + testUser.getUsername() + "&quoteid=" + 0);
    allCategories.addAttribute("allCategories", this.allCategories);
    displayedQuotes.addAttribute("displayedQuotes", this.displayedQuotes);


    for (Quote quote : this.displayedQuotes) {
      quote.setMainColors(quote.getCategory());
      String editQuoteLink = "newQuote/form?username=" + testUser.getUsername() + "&quoteid=" + quote.getId();
      quote.setEditQuoteLink(editQuoteLink);
    }
    return "my-quotes";
  }


}
