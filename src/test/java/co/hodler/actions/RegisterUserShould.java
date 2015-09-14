package co.hodler.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.eq;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.UserRepository;
import co.hodler.model.HashedPassword;
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
    User user = new User("Stef", "lol@gmail.com", new HashedPassword("pw"));

    registerUser.register(user);

    verify(userRepo).store(eq(user));
  }

  @Test(expected=IllegalArgumentException.class)
  public void notStoreUsersWithoutName() {
    User user = new User(null, "lol@gmail.com", new HashedPassword("pw"));

    registerUser.register(user);
  }

  @Test(expected=IllegalArgumentException.class)
  public void notStoreUsersWithoutEmail() {
    User user = new User("Johnny", null, new HashedPassword("pw"));

    registerUser.register(user);
  }

  @Test(expected=IllegalArgumentException.class)
  public void notStoreUsersWithoutPassword() {
    User user = new User.Builder().named("Johnny").mail("lol@gmail.com").build();

    registerUser.register(user);
  }
}
