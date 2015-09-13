package co.hodler.model;

public class User {

  private PropertyId id;
  private String name;
  private String mail;
  private String password;

  public User(PropertyId id) {
    this.id = id;
  }

  public User(Builder builder) {
    this.name = builder.name;
    this.mail = builder.mail;
    this.password = builder.password;
  }

  public PropertyId getId() {
    return id;
  }

  public static class Builder {
    private String name;
    private String mail;
    private String password;

    public Builder named(String name) {
      this.name = name;
      return this;
    }

    public Builder mail(String mail) {
      this.mail = mail;
      return this;
    }

    public Builder chosePassword(String password) {
      this.password = password;
      return this;
    }

    public User build() {
      return new User(this);
    }

  }
}
