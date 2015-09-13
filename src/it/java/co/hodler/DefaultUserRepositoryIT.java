package co.hodler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.dalesbred.Database;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import co.hodler.infrastructure.DefaultUserRepository;
import co.hodler.model.User;

public class DefaultUserRepositoryIT {

  private Database db;
  private DefaultUserRepository userRepo;

  @Before
  public void setUp() throws Exception {
    InMemoryDbSetup inMemoryDbSetup = new InMemoryDbSetup();
    db = inMemoryDbSetup.initDatabaseByUrl();

    inMemoryDbSetup.createUserTable(db);

    userRepo = new DefaultUserRepository(db);
  }

  @Test
  public void shouldStoreAndFindAllUsers() {
    User user = new User.Builder().named("Pete").chosePassword("password").mail("pete@own.foo").build();
    userRepo.store(user);

    List<User> allUsers = userRepo.findAll();

    assertThat(allUsers.get(0).getName(), equalTo("Pete"));
  }

  @Test(expected = RuntimeException.class)
  public void userNameShouldBeUnique() {
    User user = new User.Builder().named("Pete").chosePassword("password").mail("pete@own.foo").build();
    User secondUserTryingToBeNamedPeter = new User.Builder().named("Pete").chosePassword("password").mail("pete@own.bar").build();

    userRepo.store(user);
    userRepo.store(secondUserTryingToBeNamedPeter);
  }

  @Test(expected = RuntimeException.class)
  public void userMailShouldBeUnique() {
    User user = new User.Builder().named("Pete").chosePassword("password").mail("pete@own.foo").build();
    User secondUserTryingToUsePetersMail = new User.Builder().named("Pete").chosePassword("password").mail("pete@own.foo").build();

    userRepo.store(user);
    userRepo.store(secondUserTryingToUsePetersMail);
  }

  @After
  public void tearDown() {
    db.update("DROP TABLE user");
  }
}
