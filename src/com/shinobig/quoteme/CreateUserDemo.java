package com.shinobig.quoteme;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUserDemo {
  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .addAnnotatedClass(Quote.class)
        .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {

      int theId = 2;

      session.beginTransaction();
      User collectedUser = session.get(User.class, theId);
      System.out.println("collected user: " + collectedUser.getUsername());

      System.out.println("Courses: " + collectedUser.getUserQuotes());


      //User testUser = new User("Shinobi", "shinobi1");

/*

      Quote testQuote = new Quote("And the silken, sad, uncertain rustling of each purple curtain Thrilled me—filled me with fantastic terrors never felt before;", "horror", "Edgar Allan Poe", "The Raven", "raven1");
      Quote testQuoteTwo = new Quote("Ah nigga don't hate me cause I'm beautiful nigga. Maybe if you got rid of that old yee yee ass haircut, you'd get some bitches on yo dick. Oh, better yet, maybe Tanisha'll call your dog ass if she stops fuckin' with that brain surgeon or lawyer she fucking with. Niiggaaa", "comedy", "Lamar", "Grand Teft Auto V", "gta1");

//
      User testUser = session.get(User.class, theId);
//
      testUser.add(testQuote);
      testUser.add(testQuoteTwo);


      // add quotes to user

      session.save(testQuote);
      session.save(testQuoteTwo);

//session.save(testUser);

 */
      session.getTransaction().commit();

    } finally {
      session.close();
      factory.close();
    }

  }
}
