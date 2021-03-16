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
  private int quoteId;
  private User actualUser;

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
  public String newQuote(@RequestParam("username") String username, @RequestParam("quoteid") int quoteId, Model quoteModel) {


    actualUser = startingDatabase.getSingleUser(username);
    this.username = username;
    Quote quoteToEdit = new Quote();
    quoteModel.addAttribute("quotePlaceholder", "");
    quoteModel.addAttribute("authorPlaceholder", "");
    quoteModel.addAttribute("sourcePlaceholder", "");
    this.quoteId = 0;

    System.out.println(quoteId);

    if (quoteId != 0) {
      quoteToEdit = actualUser.getSingleQuote(quoteId);
      quoteModel.addAttribute("quotePlaceholder", quoteToEdit.getQuote());
      quoteModel.addAttribute("authorPlaceholder", quoteToEdit.getAuthor());
      quoteModel.addAttribute("sourcePlaceholder", quoteToEdit.getSource());
      this.quoteId = quoteId;
    }

    quoteModel.addAttribute("newQuoteToAdd", quoteToEdit);
    quoteModel.addAttribute("user", actualUser);
    quoteModel.addAttribute("categories", allCategories.getAllCategoriesMap());

    return "new-quote";
  }

  @RequestMapping("/quotesaved")
  public String quoteSaved(@Valid @ModelAttribute("newQuoteToAdd") Quote newQuoteToAdd,
                           BindingResult theBindingResult,
                           Model savedQuoteModel) {


    if (this.quoteId == 0) {
      System.out.println("saving new quote");
      String title = newQuoteToAdd.getQuote().split(" ")[0];
      title = title + newQuoteToAdd.getAuthor() + "1";
      newQuoteToAdd.setTitle(title);
      startingDatabase.addNewQuoteByUser(this.username, newQuoteToAdd);
    } else {
      System.out.println("editing quote");
      actualUser.editQuote(newQuoteToAdd, this.quoteId);
      startingDatabase.editQuoteByUser( newQuoteToAdd, this.quoteId);
    }

    savedQuoteModel.addAttribute("savedQuote", newQuoteToAdd);

    return "successfully-saved";
  }

}
