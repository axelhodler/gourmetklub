package co.hodler.infrastructure;

import java.util.List;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;

public class DefaultRestaurantRepository implements RestaurantRepository {

  @Override
  public void persist(Restaurant r) {

  }

  @Override
  public void persist(Rating rating) {

  }

  @Override
  public List<Restaurant> findAll() {
    return null;
  }

}
