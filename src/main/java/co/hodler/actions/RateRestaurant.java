package co.hodler.actions;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Rating;
import co.hodler.model.Visit;

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
    return restaurantRepository.hasVisited(new Visit(rating.getRestaurantId(), rating.getUserId()))
        && restaurantRepository.hasNotRatedYet(new Visit(rating.getRestaurantId(), rating.getUserId()));
  }

}
