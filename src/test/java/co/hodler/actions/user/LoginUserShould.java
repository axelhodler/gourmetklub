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
import co.hodler.model.user.Credentials;
import co.hodler.model.user.EMail;
import co.hodler.model.user.HashedPassword;

@RunWith(MockitoJUnitRunner.class)
public class LoginUserShould {

  @Mock
  UserRepository userRepository;
  @Mock
  ProvideToken provideToken;

  private LoginUser loginUser;

  private final EMail MAIL_ADDRESS = new EMail("horus@lupercal.com");
  private final Credentials credentials = new Credentials(MAIL_ADDRESS, new HashedPassword("astartes"));

  @Before
  public void setUp() {
    loginUser = new LoginUser(userRepository, provideToken);
  }

  @Test
  public void checkIfLoginExists() {
    loginUser.login(MAIL_ADDRESS, "astartes");

    verify(userRepository).areCredentialsCorrect(credentials);
  }

  @Test
  public void provideTokenOnCorrectLogin() {
    given(userRepository.areCredentialsCorrect(credentials)).willReturn(true);

    loginUser.login(MAIL_ADDRESS, "astartes");

    verify(provideToken).to(MAIL_ADDRESS);
  }

  @Test
  public void notProvideTokenOnIncorrectLogin() {
    given(userRepository.areCredentialsCorrect(credentials)).willReturn(false);

    loginUser.login(MAIL_ADDRESS, "astartes");

    verify(provideToken, never()).to(MAIL_ADDRESS);
  }
}
