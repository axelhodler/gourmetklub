package co.hodler.actions.user;

import co.hodler.infrastructure.repositories.UserRepository;
import co.hodler.model.user.HashedPassword;

public class LoginUser {

  private UserRepository userRepository;

  public LoginUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void login(String mailAddress, String password) {
    userRepository.areCredentialsCorrect(mailAddress, new HashedPassword("password"));
  }

}
