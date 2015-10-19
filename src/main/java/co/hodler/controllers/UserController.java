package co.hodler.controllers;

import co.hodler.actions.user.RegisterUser;
import co.hodler.model.UserDto;
import spark.Request;
import spark.Response;

public class UserController {

  private RegisterUser registerUser;
  private UserDto dto;

  public UserController(RegisterUser registerUser, UserDto dto) {
    this.registerUser = registerUser;
    this.dto = dto;
  }

  public String registerUser(Request request, Response response) {
    registerUser.register(dto.fromJson(request.body()));
    return null;
  }
}
