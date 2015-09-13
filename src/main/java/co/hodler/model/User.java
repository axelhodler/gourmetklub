package co.hodler.model;

public class User {

  private PropertyId id;
  private String name;
  private String mail;
  private HashedPassword password;

  public User(PropertyId id) {
    this.id = id;
  }

  public User(int id, String name, String mail, String password) {
    this.id = new PropertyId(id);
    this.name = name;
    this.mail = mail;
    this.password = new HashedPassword(password);
  }

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
      return new User(this);
    }

  }
}
