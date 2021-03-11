package com.shinobig.quoteme;

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
  private String username;

  public AddNewQuoteController() {
  }

  public AddNewQuoteController(StartingDatabase startingDatabase) {
    this.startingDatabase = startingDatabase;
  }

  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public String newQuote(@RequestParam("username") String username, Model quoteModel) {

    User actualUser = startingDatabase.getSingleUser(username);
    this.username = username;
    Quote newQuoteToAdd = new Quote();
    quoteModel.addAttribute("newQuoteToAdd", newQuoteToAdd);
    quoteModel.addAttribute("user", actualUser);


    return "new-quote";
  }

  @RequestMapping("/quotesaved")
  public String quoteSaved(@Valid @ModelAttribute("newQuoteToAdd") Quote newQuoteToAdd,
                           BindingResult theBindingResult,
                           Model savedQuoteModel) {

    // Check if quote exists
    System.out.println("saving new quote");

    // Save new quote
    //Quote quoteToAdd = new Quote("this is a testing quote no 3", "other", "Oscar Wilde", "Dorian Gray", "Dorian1");
    startingDatabase.addNewQuoteByUser(this.username, newQuoteToAdd);



    // Display new information

    savedQuoteModel.addAttribute("savedQuote", newQuoteToAdd);


    return "successfully-saved";
  }

}
