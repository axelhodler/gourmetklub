package co.hodler.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.dalesbred.Database;

import co.hodler.model.User;

public class InmemoryDatabaseTest {
  public static void main(String[] args) {
    try {
      Class.forName("org.h2.Driver");
      Connection con = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    Database db = Database.forUrlAndCredentials("jdbc:h2:mem:test", "", "");
    db.update("CREATE TABLE user (id INT, name VARCHAR(50));");
    db.update("INSERT INTO user(id, name) VALUES(1, 'foo');");
    List<User> allUsers = db.findAll(User.class, "select * from user");
    System.out.println(allUsers.size());
  }
}
