package co.hodler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.dalesbred.Database;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.hodler.infrastructure.repositories.DefaultUserRepository;
import co.hodler.model.user.HashedPassword;
import co.hodler.model.user.PropertyId;
import co.hodler.model.user.User;

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
    User user = new User("Pete", "pete@own.foo",
        new HashedPassword("password"));
    userRepo.store(user);

    List<User> allUsers = userRepo.findAll();

    assertThat(allUsers.get(0).getName(), equalTo("Pete"));
  }

  @Test(expected = RuntimeException.class)
  public void userNameShouldBeUnique() {
    User user = new User("Pete", "pete@own.foo",
        new HashedPassword("password"));
    User secondUserTryingToBeNamedPeter = new User("Pete", "pete@own.bar",
        new HashedPassword("password"));

    userRepo.store(user);
    userRepo.store(secondUserTryingToBeNamedPeter);
  }

  @Test(expected = RuntimeException.class)
  public void userMailShouldBeUnique() {
    User user = new User("Pete", "pete@own.foo",
        new HashedPassword("password"));
    User secondUserTryingToUsePetersMail = new User("Pete", "pete@own.foo",
        new HashedPassword("password"));

    userRepo.store(user);
    userRepo.store(secondUserTryingToUsePetersMail);
  }

  @Test
  public void canGetUserIdByMailAndPassword() {
    String petesPassword = "password";
    String petesMail = "pete@own.foo";
    User user = new User("Pete", petesMail, new HashedPassword(petesPassword));

    userRepo.store(user);

    assertThat(userRepo.fetchUserIdFor(petesPassword, petesMail),
        equalTo(new PropertyId(1)));
  }

  @After
  public void tearDown() {
    db.update("DROP TABLE user");
  }
}
