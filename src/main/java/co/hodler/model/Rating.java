package co.hodler.model;

public class Rating {

  private String restaurantId;
  private String userId;
  private String rating;

  public Rating(String restaurantId, String userId, String rating) {
    this.restaurantId = restaurantId;
    this.userId = userId;
    this.rating = rating;
  }

  public String getUserId() {
    return userId;
  }

  public String getRestaurantId() {
    return restaurantId;
  }

}
