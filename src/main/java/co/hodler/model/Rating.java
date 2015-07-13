package co.hodler.model;

import co.hodler.model.stars.Stars;

public class Rating {

  private String restaurantId;
  private String userId;
  private Stars rating;

  public Rating(String restaurantId, String userId, Stars stars) {
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
