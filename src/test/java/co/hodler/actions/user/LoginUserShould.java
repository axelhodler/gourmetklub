package co.hodler.actions.user;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.repositories.UserRepository;
import co.hodler.model.user.HashedPassword;

@RunWith(MockitoJUnitRunner.class)
public class LoginUserShould {

  @Mock
  UserRepository userRepository;

  @Test
  public void checkIfLoginExists() {
    LoginUser loginUser = new LoginUser(userRepository);

    loginUser.login("horus@lupercal.com", "password");

    verify(userRepository).areCredentialsCorrect("horus@lupercal.com", new HashedPassword("password"));
  }
}
