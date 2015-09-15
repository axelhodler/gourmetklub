package co.hodler.model;

public class User {

  private PropertyId id;
  private String name;
  private String mail;
  private HashedPassword password;

  public User(String name, String mail, HashedPassword hashedPassword) {
    this.name = name;
    this.mail = mail;
    this.password = hashedPassword;
  }

  public User(int id, String name, String mail, String password) {
    this.id = new PropertyId(id);
    this.name = name;
    this.mail = mail;
    this.password = new HashedPassword(password);
  }

  public PropertyId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMail() {
    return mail;
  }

  public HashedPassword getHashedPassword() {
    return password;
  }
}
