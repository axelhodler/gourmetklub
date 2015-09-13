package co.hodler.infrastructure;

import java.util.List;

import org.dalesbred.Database;

import co.hodler.model.HashedPassword;
import co.hodler.model.PropertyId;
import co.hodler.model.User;

public class DefaultUserRepository implements UserRepository {

  private Database database;

  /**
   * Necessary for some reason, DefaultRestaurantRepository does not need it
   */
  public DefaultUserRepository() {

  }

  public DefaultUserRepository(Database database) {
    this.database = database;
  }

  public void store(User user) {
    database.update("INSERT INTO user(name, mail, passwordHashed) VALUES (?, ?, ?);",
        user.getName(), user.getMail(), user.getHashedPassword().value());
  }

  public List<User> findAll() {
    return database.findAll(User.class, "SELECT * FROM user");
  }

  public PropertyId fetchUserIdFor(String password, String mailAddress) {
    return database.findUnique(User.class,
        "SELECT * FROM user WHERE passwordHashed = ? AND mail = ?",
        new HashedPassword(password).value(), mailAddress).getId();
  }

}
