package co.hodler.infrastructure.repositories;

import co.hodler.model.user.User;

public interface UserRepository {

  public void store(User user);
}
