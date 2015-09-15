package co.hodler.controllers;

import co.hodler.actions.RegisterUser;
import spark.Request;
import spark.Response;

public class UserController {

  private RegisterUser registerUser;

  public UserController(RegisterUser registerUser) {
    this.registerUser = registerUser;
  }

  public String registerUser(Request request, Response response) {
    registerUser.register(null);
    return null;
  }
}
