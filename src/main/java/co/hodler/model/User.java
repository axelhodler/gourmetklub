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

  @Deprecated
  public User(Builder builder) {
    this.name = builder.name;
    this.mail = builder.mail;
    this.password = builder.password;
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

  @Deprecated
  public static class Builder {
    private String name;
    private String mail;
    private HashedPassword password;

    public Builder named(String name) {
      this.name = name;
      return this;
    }

    public Builder mail(String mail) {
      this.mail = mail;
      return this;
    }

    public Builder chosePassword(String password) {
      this.password = new HashedPassword(password);
      return this;
    }

    public User build() {
      if (password == null) {
        throw new IllegalArgumentException("Password needs to be provided");
      }
      return new User(this);
    }

  }
}
