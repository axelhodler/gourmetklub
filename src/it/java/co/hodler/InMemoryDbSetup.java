package co.hodler;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.dalesbred.Database;

public class InMemoryDbSetup {

  private final String JDBC_URL = "jdbc:h2:mem:test";

  public Database initDatabaseByUrl() throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    DriverManager.getConnection(JDBC_URL, "", "");
    return Database.forUrlAndCredentials(JDBC_URL, "", "");
  }

  public void createRestaurantTable(Database db) {
    db.update("CREATE TABLE restaurant (id INT NOT NULL AUTO_INCREMENT,"
        + "name VARCHAR(50),"
        + "pickerId INT,"
        + "latitude VARCHAR(50),"
        + "longitude VARCHAR(50));");
  }

  public void createUserTable(Database db) {
    db.update("CREATE TABLE user (id INT NOT NULL AUTO_INCREMENT,"
        + "name VARCHAR(50),"
        + "mail VARCHAR(250),"
        + "passwordHashed VARCHAR(250),"
        + "CONSTRAINT name_unique UNIQUE(name),"
        + "CONSTRAINT mail_unique UNIQUE(mail));");
  }

  
}
