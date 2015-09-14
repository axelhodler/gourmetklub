package co.hodler.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.eq;

import org.junit.Before;
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

  private RegisterUser registerUser;

  @Before
  public void setUp() {
    registerUser = new RegisterUser(userRepo);
  }

  @Test
  public void storeUser() {
    User user = new User("Stef", "pw", "lol@gmail.com");

    registerUser.register(user);

    verify(userRepo).store(eq(user));
  }

  @Test(expected=IllegalArgumentException.class)
  public void notStoreUsersWithoutName() {
    User user = new User.Builder().chosePassword("pw").mail("lol@gmail.com").build();

    registerUser.register(user);
  }

  @Test(expected=IllegalArgumentException.class)
  public void notStoreUsersWithoutEmail() {
    User user = new User.Builder().named("Johnny").chosePassword("pw").build();

    registerUser.register(user);
  }

  @Test(expected=IllegalArgumentException.class)
  public void notStoreUsersWithoutPassword() {
    User user = new User.Builder().named("Johnny").mail("lol@gmail.com").build();

    registerUser.register(user);
  }
}
