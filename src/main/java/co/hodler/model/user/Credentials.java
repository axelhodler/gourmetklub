package co.hodler.model.user;

public class Credentials {

  private EMail mailAddress;
  private HashedPassword hashedPassword;

  public Credentials(EMail mailAddress, HashedPassword hashedPassword) {
    this.mailAddress = mailAddress;
    this.hashedPassword = hashedPassword;
  }

  public String getMailAddress() {
    return mailAddress.value();
  }

  public String getHashedPassword() {
    return hashedPassword.value();
  }
}
