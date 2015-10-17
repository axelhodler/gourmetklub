package co.hodler.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UserDtoShould {

  private String userJson;
  private String johnAsJson;

  private UserDto dto;

  @Before
  public void setUp() {
    userJson = "{\"name\":\"foo\", \"mail\":\"bar\", \"password\":\"baz\"}";
    johnAsJson = "{\"name\":\"johnny\", \"mail\":\"john@john.org\", \"password\":\"johnny123\"}";

    dto = new UserDto();
  }

  @Test
  public void canDeserializeUserNameFromJson() {
    assertThat(dto.fromJson(userJson).getName(), is("foo"));
    assertThat(dto.fromJson(johnAsJson).getName(), is("johnny"));
  }

  @Test
  public void canDeserializeUserMailFromJson() {
    assertThat(dto.fromJson(userJson).getMail(), is("bar"));
    assertThat(dto.fromJson(johnAsJson).getMail(), is("john@john.org"));
  }

  @Test
  public void deserializeUserPasswordFromJson() {
    assertThat(dto.fromJson(userJson).getHashedPassword(), is(new HashedPassword("baz")));
    assertThat(dto.fromJson(johnAsJson).getHashedPassword(), is(new HashedPassword("johnny123")));
  }
}
