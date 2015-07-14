package co.hodler.actions;

import java.util.List;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Restaurant;

public class RetrieveRestaurants {

  private RestaurantRepository restaurantRepo;

  public RetrieveRestaurants(RestaurantRepository restaurantRepo) {
    this.restaurantRepo = restaurantRepo;
  }

  public List<Restaurant> all() {
    return restaurantRepo.findAll();
  }

}
