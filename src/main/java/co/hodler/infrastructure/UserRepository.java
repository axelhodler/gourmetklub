package co.hodler.infrastructure;

import co.hodler.model.User;

public interface UserRepository {

  public void store(User user);
}
