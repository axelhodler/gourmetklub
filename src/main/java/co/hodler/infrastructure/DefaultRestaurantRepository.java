package co.hodler.infrastructure;

import java.util.List;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;
import co.hodler.model.Visit;

public class DefaultRestaurantRepository implements RestaurantRepository {

  @Override
  public void persist(Restaurant r) {

  }

  @Override
  public void persist(Visit visit) {

  }

  @Override
  public void persist(Rating rating) {

  }

  @Override
  public boolean exists(Visit visit) {
    return false;
  }

  @Override
  public boolean isRated(Visit visit) {
    return false;
  }

  @Override
  public List<Restaurant> findAll() {
    return null;
  }

}
