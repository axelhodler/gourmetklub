package co.hodler.actions;

import co.hodler.infrastructure.RestaurantRepository;

public class RateRestaurant {

  private RestaurantRepository restaurantRepository;

  public RateRestaurant(RestaurantRepository restaurantRepository) {
    this.restaurantRepository = restaurantRepository;
  }

  public void rate(String restaurantId, String userId, String rating) {
    restaurantRepository.rate(restaurantId, userId, rating);
  }

}
