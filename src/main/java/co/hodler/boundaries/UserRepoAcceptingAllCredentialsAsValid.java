package co.hodler.boundaries;

import co.hodler.infrastructure.repositories.UserRepository;
import co.hodler.model.user.Credentials;
import co.hodler.model.user.PropertyId;
import co.hodler.model.user.User;

import java.util.List;

public class UserRepoAcceptingAllCredentialsAsValid implements UserRepository {
  @Override
  public void store(User user) {

  }

  @Override
  public List<User> findAll() {
    return null;
  }

  @Override
  public PropertyId fetchUserIdFor(String password, String mailAddress) {
    return null;
  }

  @Override
  public boolean areCredentialsCorrect(Credentials credentials) {
    return true;
  }
}
