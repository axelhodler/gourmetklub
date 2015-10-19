package co.hodler.actions.user;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ProvideTokenShould {

  @Test
  public void provideSameValidTokenForEveryone() {
    ProvideToken provideToken = new ProvideToken();

    assertThat(provideToken.to("someone@mail.com"), is("validtoken"));
  }
}
