package co.hodler.model.user;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import co.hodler.model.user.HashedPassword;

public class HashedPasswordTest {

  @Test
  public void shouldHashPasswordWhenAskedForItsValue() {
    HashedPassword hashedPw = new HashedPassword("password");

    assertThat(hashedPw.value(), equalTo("5f4dcc3b5aa765d61d8327deb882cf99"));
  }
}
