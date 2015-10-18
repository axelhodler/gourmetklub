package co.hodler.infrastructure.repositories;

import java.util.List;

import org.dalesbred.Database;

import co.hodler.model.user.HashedPassword;
import co.hodler.model.user.PropertyId;
import co.hodler.model.user.User;

public class DefaultUserRepository implements UserRepository {

  private Database database;

  public DefaultUserRepository(Database database) {
    this.database = database;
  }

  @Override
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
