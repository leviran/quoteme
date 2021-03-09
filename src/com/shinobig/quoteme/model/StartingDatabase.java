package com.shinobig.quoteme.model;


import com.shinobig.quoteme.Quote;
import com.shinobig.quoteme.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StartingDatabase {

  private List<User> allUsers;

  public StartingDatabase() {

    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .addAnnotatedClass(Quote.class)
        .buildSessionFactory();

    Session session = factory.getCurrentSession();


    try {
      session.beginTransaction();
      allUsers = session
          .createQuery("from User")
          .getResultList();
      session.getTransaction().commit();
    } finally {
      session.close();
    }

  }

// terror
  // romance
  // scifi
  // fantasy
  // comedy
  // mystery
  // adventure
  // self
  // other

  public List<User> getAllUsers() {
    return allUsers;
  }

  public void setAllUsers(List<User> allUsers) {
    this.allUsers = allUsers;
  }

  public User getSingleUser(String username){
    for(User user : allUsers){
      if(user.getUsername().equals(username)){
        return user;
      }
    }
    return null;
  }

  public User isRightPassword (String username, String password){
    User user = getSingleUser(username);
    if(user != null){
      if(user.getPassword().equals(password)){
        return user;
      }
    }
    return null;
  }

}
