package co.hodler.actions.user;

import co.hodler.model.user.EMail;

public class ProvideToken {

  public String to(EMail mailAddress) {
    return "validtoken";
  }

}
