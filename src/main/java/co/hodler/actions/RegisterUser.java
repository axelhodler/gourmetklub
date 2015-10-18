package co.hodler.actions;

import co.hodler.infrastructure.repositories.UserRepository;
import co.hodler.model.user.User;

public class RegisterUser {

  private UserRepository userRepo;

  public RegisterUser(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public void register(User user) {
    if (user.getName() == null) {
      throw new IllegalArgumentException("Username needs to be provided");
    } else if (user.getMail() == null) {
      throw new IllegalArgumentException("Mail address needs to be provided");
    } else if (user.getHashedPassword() == null) {
      throw new IllegalArgumentException("Necessary to provide a password");
    }
    userRepo.store(user);
  }

}
