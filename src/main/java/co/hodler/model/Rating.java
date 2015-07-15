package co.hodler.model;

import co.hodler.model.stars.Stars;

public class Rating {

  private String restaurantId;
  private String userId;
  private Stars rating;

  public Rating(Visit visit, Stars stars) {
    this.restaurantId = visit.getRestaurantId();
    this.userId = visit.getUserId();
    this.rating = rating;
  }

  public String getUserId() {
    return userId;
  }

  public String getRestaurantId() {
    return restaurantId;
  }

}
