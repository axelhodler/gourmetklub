package co.hodler.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.eq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.UserRepository;
import co.hodler.model.User;

@RunWith(MockitoJUnitRunner.class)
public class RegisterUserShould {

  @Mock
  UserRepository userRepo;

  @Test
  public void storeUser() {
    RegisterUser registerUser = new RegisterUser(userRepo);
    User user = new User.Builder().named("Stef").chosePassword("pw").mail("lol@gmail.com").build();

    registerUser.register(user);

    verify(userRepo).store(eq(user));
  }
}
