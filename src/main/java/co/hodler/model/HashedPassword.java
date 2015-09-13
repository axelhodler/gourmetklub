package co.hodler.model;

public class HashedPassword {

  private String password;

  public HashedPassword(String password) {
    this.password = password;
  }

  public String value() {
    return new Md5Hash(password).value();
  }
}
