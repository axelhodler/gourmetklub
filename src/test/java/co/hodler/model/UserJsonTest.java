package co.hodler.model;

import static com.eclipsesource.json.JsonObject.readFrom;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.eclipsesource.json.JsonObject;

public class UserJsonTest {

  @Test
  public void canDeserializeUserFromJson() {
    String serializedUser = "{\"name\":\"foo\", \"mail\":\"bar\", \"password\":\"baz\"}";
    JsonObject userJsonObject = readFrom(serializedUser);

    UserJson userJson = new UserJson(userJsonObject);

    User user = userJson.toUser();
    assertThat(user.getName(), is("foo"));
    assertThat(user.getMail(), is("bar"));
    assertThat(user.getHashedPassword(), is(new HashedPassword("baz")));
  }
}
