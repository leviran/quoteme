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
      System.out.println("creating user");
     // User testUser = new User("Maria", "maria1");
      int theId = 1;


      Quote testQuote = new Quote("Le prometió seguirla hasta el fin del mundo, pero más tarde, cuando arreglara sus asuntos, y ella se había cansado de esperarlo identificándolo siempre con los hombres altos y bajos, rubios y morenos…", "romance", "Gabriel García Márquez", "Cien años de soledad", "cien1");
      Quote testQuoteTwo = new Quote("Sólo tú puedes decidir qué hacer con el tiempo que se te ha dado", "fantasy", " J. R. R. Tolkien", "El Señor de los Anillos", "senor1");


      session.beginTransaction();
      User testUser = session.get(User.class, theId);

      testUser.add(testQuote);
      testUser.add(testQuoteTwo);



      // add quotes to user

      session.save(testQuote);
      session.save(testQuoteTwo);



      session.getTransaction().commit();


      System.out.println("user successfully saved");
    } finally {
      session.close();
      factory.close();
    }

  }
}
