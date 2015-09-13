package co.hodler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.dalesbred.Database;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.hodler.infrastructure.DefaultUserRepository;

public class DefaultUserRepositoryIT {

  private Database db;
  private DefaultUserRepository userRepo;

  @Before
  public void setUp() throws Exception {
    InMemoryDbSetup inMemoryDbSetup = new InMemoryDbSetup();
    db = inMemoryDbSetup.initDatabaseByUrl();

    db.update("CREATE TABLE user (id INT NOT NULL AUTO_INCREMENT,"
                                      + "name VARCHAR(50),"
                                      + "mail VARCHAR(255),"
                                      + "passwordHashed VARCHAR(255));");

    userRepo = new DefaultUserRepository();
  }

  @Test
  public void should() {
  }

  @After
  public void tearDown() {
    db.update("DROP TABLE user");
  }
}