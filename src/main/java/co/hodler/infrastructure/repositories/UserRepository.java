package co.hodler.infrastructure.repositories;

import co.hodler.model.User;

public interface UserRepository {

  public void store(User user);
}
