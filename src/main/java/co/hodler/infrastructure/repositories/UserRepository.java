package co.hodler.infrastructure.repositories;

import java.util.List;

import co.hodler.model.user.PropertyId;
import co.hodler.model.user.User;

public interface UserRepository {

  public void store(User user);

  public List<User> findAll();

  public PropertyId fetchUserIdFor(String password, String mailAddress);
}
