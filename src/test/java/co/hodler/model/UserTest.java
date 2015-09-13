package co.hodler.model;

import org.junit.Test;

public class UserTest {

  @Test
  public void canCreateUser() {
    User user = new User.Builder().named("peter").mail("peter@peter.com").chosePassword("password").build();
  }
}
