package co.hodler.actions;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Restaurant;

public class AddRestaurant {

  RestaurantRepository repository;

  public AddRestaurant(RestaurantRepository repository) {
    this.repository = repository;
  }

  public void add(Restaurant r) {
    repository.persist(r);
  }

}
