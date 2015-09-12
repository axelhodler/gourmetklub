package co.hodler.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class UserTest {

  @Test
  public void shouldBeIdentifiedByPropertyId() {
    PropertyId id = new PropertyId(1);

    User user = new User(id);

    assertThat(id, equalTo(user.getId()));
  }
}
