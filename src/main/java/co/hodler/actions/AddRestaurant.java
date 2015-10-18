package co.hodler.actions;

import co.hodler.infrastructure.repositories.RestaurantRepository;
import co.hodler.model.Restaurant;

public class AddRestaurant {

  private RestaurantRepository repository;
  private ProvideCoordinates coordinatesProvider;

  public AddRestaurant(RestaurantRepository repository, ProvideCoordinates coordinatesProvider) {
    this.repository = repository;
    this.coordinatesProvider = coordinatesProvider;
  }

  public void add(Restaurant r) {
    r.setCoordinates(coordinatesProvider.fetchCoordinatesFor(r.getAddress()));
    repository.persist(r);
  }

}
