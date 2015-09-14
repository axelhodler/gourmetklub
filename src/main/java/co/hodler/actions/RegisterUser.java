package co.hodler.actions;

import co.hodler.infrastructure.UserRepository;
import co.hodler.model.User;

public class RegisterUser {

  private UserRepository userRepo;

  public RegisterUser(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public void register(User user) {
    userRepo.store(user);
  }

}
