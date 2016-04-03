package co.hodler.boundaries;

import co.hodler.actions.user.ProvideToken;
import co.hodler.model.user.EMail;

public class ProvideJsonWebToken implements ProvideToken {
  @Override
  public String to(EMail mailAddress) {
    return null;
  }
}
