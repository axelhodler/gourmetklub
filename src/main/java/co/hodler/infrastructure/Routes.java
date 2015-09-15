package co.hodler.infrastructure;

import static spark.Spark.post;

import co.hodler.controllers.UserController;

public class Routes {

  private UserController userController;

  public Routes(UserController userController) {
    this.userController = userController;
  }

  public void initialise() {
    post("register", (request, response) ->
      userController.registerUser(request, response));
  }

}
