package co.hodler.actions.user;

import co.hodler.model.user.EMail;

public interface ProvideToken {

  String to(EMail mailAddress);

}
