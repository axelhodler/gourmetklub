package co.hodler.actions.user;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
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
  @Mock
  ProvideToken provideToken;

  private LoginUser loginUser;

  @Before
  public void setUp() {
    loginUser = new LoginUser(userRepository, provideToken);
  }

  @Test
  public void checkIfLoginExists() {
    loginUser.login("horus@lupercal.com", "password");

    verify(userRepository).areCredentialsCorrect("horus@lupercal.com", new HashedPassword("password"));
  }

  @Test
  public void provideTokenOnCorrectLogin() {
    given(userRepository.areCredentialsCorrect("horus@lupercal.com", new HashedPassword("astartes"))).willReturn(true);

    loginUser.login("horus@lupercal.com", "astartes");

    verify(provideToken).to("horus@lupercal.com");
  }

  @Test
  public void notProvideTokenOnIncorrectLogin() {
    given(userRepository.areCredentialsCorrect("horus@lupercal.com", new HashedPassword("astartes"))).willReturn(false);

    loginUser.login("horus@lupercal.com", "astartes");

    verify(provideToken, never()).to("horus@lupercal.com");
  }
}
