package co.hodler.actions;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Rating;

public class RateRestaurant {

  private RestaurantRepository restaurantRepository;

  public RateRestaurant(RestaurantRepository restaurantRepository) {
    this.restaurantRepository = restaurantRepository;
  }

  public void rate(Rating rating) {
    if (allowedToRate(rating)) {
      restaurantRepository.rate(rating);
    }
  }

  private boolean allowedToRate(Rating rating) {
    return restaurantRepository.hasVisited(rating.getRestaurantId(), rating.getUserId())
        && restaurantRepository.hasNotRatedYet(rating.getRestaurantId(), rating.getUserId());
  }

}
