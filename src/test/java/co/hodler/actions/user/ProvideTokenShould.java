package co.hodler.actions.user;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import co.hodler.model.user.EMail;

public class ProvideTokenShould {

  @Test
  public void provideSameValidTokenForEveryone() {
    ProvideToken provideToken = new ProvideToken();

    assertThat(provideToken.to(new EMail("someone@mail.com")), is("validtoken"));
  }
}
