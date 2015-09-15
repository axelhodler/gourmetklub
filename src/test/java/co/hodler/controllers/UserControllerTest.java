package co.hodler.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.actions.RegisterUser;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

  @Mock
  RegisterUser registerUser;

  @Test
  public void registerUser() {
    UserController c = new UserController(registerUser);
  }
}
