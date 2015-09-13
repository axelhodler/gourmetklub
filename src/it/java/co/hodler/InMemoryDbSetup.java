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

}
