package co.hodler.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.actions.RegisterUser;
import co.hodler.model.HashedPassword;
import co.hodler.model.User;
import co.hodler.model.UserDto;
import spark.Request;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

  @Mock
  RegisterUser registerUser;
  @Mock
  Request request;
  @Captor
  ArgumentCaptor<User> user;

  private static final String USER_JSON = "{\"name\":\"johnny\", \"mail\":\"john@john.org\", \"password\":\"johnny123\"}";

  @Test
  public void registerUser() {
    given(request.body()).willReturn(USER_JSON);
    UserController c = new UserController(registerUser, new UserDto());

    c.registerUser(request, null);

    verify(registerUser).register(user.capture());
    assertThat(user.getValue().getName(), is("johnny"));
    assertThat(user.getValue().getMail(), is("john@john.org"));
    assertThat(user.getValue().getHashedPassword(),
        is(new HashedPassword("johnny123")));
  }
}
