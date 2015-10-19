package co.hodler.actions.user;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateTokenShould {

  @Test
  public void acceptEveryTokenAsValid() {
    ValidateToken validateToken = new ValidateToken();

    assertTrue(validateToken.validate("token"));
  }
}
