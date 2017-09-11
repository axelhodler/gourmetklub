package co.hodler.learning;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.BeforeClass;
import org.junit.Test;

import java.security.Key;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class JJWTLibraryShould {

  private static String secretBase64encoded;

  @BeforeClass
  public static void setUp() {
    Key key = MacProvider.generateKey();
    secretBase64encoded = TextCodec.BASE64.encode(key.getEncoded()).toString();
  }

  @Test
  public void createVerifyableJsonWebTokens() {
    String token = createTokenFor("Joe");

    assertThat(Jwts.parser()
            .setSigningKey(secretBase64encoded)
            .parseClaimsJws(token)
            .getBody()
            .getSubject(), is("Joe"));
  }

  @Test
  public void tamperingWithTheTokenThrowsSignatureException() {
    String token = createTokenFor("Joe");
    try {
      Jwts.parser()
              .setSigningKey(secretBase64encoded)
              .parseClaimsJws(token + "X");
      fail();
    } catch (SignatureException e) {}
  }

  private String createTokenFor(String name) {
    return Jwts.builder()
            .setSubject(name)
            .signWith(SignatureAlgorithm.HS512, secretBase64encoded)
            .compact();
  }

}
