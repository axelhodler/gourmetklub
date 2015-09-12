package co.hodler.model;

public class User {

  private PropertyId id;

  public User(PropertyId id) {
    this.id = id;
  }

  public String name;

  public PropertyId getId() {
    return id;
  }

}
