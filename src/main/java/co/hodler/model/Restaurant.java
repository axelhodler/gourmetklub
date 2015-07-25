package co.hodler.model;

public class Restaurant {

  private int id;
  private String name;
  private int pickerId;
  private String address;
  private Coordinates coordinates;

  public Restaurant() {
  }

  public Restaurant(String name, int pickerId) {
    this.name = name;
    this.pickerId = pickerId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPickerId() {
    return this.pickerId;
  }

  public void setPickerId(int id) {
    this.pickerId = id;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return this.address;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

}
