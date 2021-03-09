package com.shinobig.quoteme;

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

  public HomeController() {
  }

  public HomeController(StartingDatabase startingDatabase) {
    this.startingDatabase = startingDatabase;
  }

  @RequestMapping("/")
  public String showMainPage(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "index";
  }

  @RequestMapping("/myQuotes")
  public String myQuotes(
      @Valid @ModelAttribute("user") User theUser,
      BindingResult theBindingResult, Model testModel) {

    if (theBindingResult.hasErrors()) {
      return "index";
    } else if (startingDatabase.isRightPassword(theUser.getUsername(), theUser.getPassword()) == null) {
      return "index";
    } else {
      User currentUser = startingDatabase.isRightPassword(theUser.getUsername(), theUser.getPassword());
      testModel.addAttribute("currentUser", currentUser);
      return "my-quotes";
    }

  }


}
