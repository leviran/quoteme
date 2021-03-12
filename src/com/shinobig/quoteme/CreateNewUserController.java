package com.shinobig.quoteme;


import com.shinobig.quoteme.model.StartingDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/newuser")
public class CreateNewUserController {
  private StartingDatabase startingDatabase;

  public CreateNewUserController() {
  }

  public CreateNewUserController(StartingDatabase startingDatabase) {
    this.startingDatabase = startingDatabase;
  }

  @RequestMapping("/createnewuser")
  public String createNewUser(Model model) {
    User user = new User();
    model.addAttribute("user", user);

    return "new-user-form";
  }

  @RequestMapping("/newusercreated")
  public String newUserCreated(
      @Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult) {

    // connect beans --listo

    // create form and bind it


    // check if form is working

    // connect form with database
    if (theBindingResult.hasErrors()) {
      return "new-user-form";
    } else if (startingDatabase.createNewUser(theUser)) {
      return "new-user-created";
    } else {
      return "new-user-form";
    }

    // check if user already exists

    //save user


  }


}
