package co.hodler.boundaries;

import co.hodler.actions.user.ProvideToken;
import co.hodler.model.user.EMail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class ProvideJsonWebToken implements ProvideToken {

  private final String insecureHardCodedSecretForTesting =
          "NXBmNcnoqvKjBHvTnMdJAyeXrY9HnmpotrDkmn/1ExZAGBzYQ0hIM15WVWtIYVC7JUgrKHJa6EH4/DJ8nN2WlQ==";

  @Override
  public String to(EMail mailAddress) {
    return Jwts.builder()
            .setSubject(mailAddress.value())
            .signWith(SignatureAlgorithm.HS512, insecureHardCodedSecretForTesting)
            .compact();
  }
}
