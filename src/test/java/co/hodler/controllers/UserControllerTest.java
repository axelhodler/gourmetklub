package co.hodler.controllers;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.actions.RegisterUser;
import spark.Request;
import spark.Response;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

  @Mock
  RegisterUser registerUser;
  @Mock
  Request request;
  @Mock
  Response response;

  @Test
  public void registerUser() {
    UserController c = new UserController(registerUser);

    c.registerUser(request, response);

    verify(registerUser).register(null);
  }
}
