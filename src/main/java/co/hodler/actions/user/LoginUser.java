package co.hodler.actions.user;

import co.hodler.infrastructure.repositories.UserRepository;
import co.hodler.model.user.Credentials;
import co.hodler.model.user.EMail;
import co.hodler.model.user.HashedPassword;

public class LoginUser {

  private UserRepository userRepository;
  private ProvideToken provideToken;

  public LoginUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public LoginUser(UserRepository userRepository, ProvideToken provideToken) {
    this.userRepository = userRepository;
    this.provideToken = provideToken;
  }

  public String login(EMail mailAddress, String password) {
    if (userRepository.areCredentialsCorrect(new Credentials(mailAddress, new HashedPassword(password))))
      return provideToken.to(mailAddress);
    else
      return "";
  }

}
