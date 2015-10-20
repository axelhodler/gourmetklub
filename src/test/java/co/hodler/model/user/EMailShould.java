package co.hodler.model.user;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class EMailShould {

  @Test(expected = RuntimeException.class)
  public void containAtSign() {
    new EMail("hallo");
  }

  @Test(expected = RuntimeException.class)
  public void containADot() {
    new EMail("@");
  }

  @Test
  public void containSthBetweenAtAndDot(){
    EMail mail = new EMail("hi@hi.hi");

    assertThat(mail.value(), is("hi@hi.hi"));
  }
}
