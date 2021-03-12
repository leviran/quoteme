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

@Controller
@RequestMapping("newQuote")
public class AddNewQuoteController {

  private StartingDatabase startingDatabase;
  private AllCategories allCategories;
  private String username;

  public AddNewQuoteController() {
  }

  public AddNewQuoteController(StartingDatabase startingDatabase) {
    this.startingDatabase = startingDatabase;
  }

  public AddNewQuoteController(StartingDatabase startingDatabase, AllCategories allCategories) {
    this.startingDatabase = startingDatabase;
    this.allCategories = allCategories;
  }

  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public String newQuote(@RequestParam("username") String username, Model quoteModel) {

    User actualUser = startingDatabase.getSingleUser(username);
    this.username = username;
    Quote newQuoteToAdd = new Quote();
    quoteModel.addAttribute("newQuoteToAdd", newQuoteToAdd);
    quoteModel.addAttribute("user", actualUser);
    quoteModel.addAttribute("categories", allCategories.getAllCategoriesMap());


    return "new-quote";
  }

  @RequestMapping("/quotesaved")
  public String quoteSaved(@Valid @ModelAttribute("newQuoteToAdd") Quote newQuoteToAdd,
                           BindingResult theBindingResult,
                           Model savedQuoteModel) {
    // Check if quote exists
    System.out.println("saving new quote");

    // Save new quote
    String title = newQuoteToAdd.getQuote().split(" ")[0];
    title = title + newQuoteToAdd.getAuthor() + "1";
    newQuoteToAdd.setTitle(title);

    startingDatabase.addNewQuoteByUser(this.username, newQuoteToAdd);

    savedQuoteModel.addAttribute("savedQuote", newQuoteToAdd);

    return "successfully-saved";
  }

}
