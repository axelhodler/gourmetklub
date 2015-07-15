package co.hodler.infrastructure;

import java.util.List;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;

public class DefaultRestaurantRepository implements RestaurantRepository {

  @Override
  public void persist(Restaurant r) {

  }

  @Override
  public void addVisitorFor(String restaurantId, String userId) {

  }

  @Override
  public void rate(Rating rating) {

  }

  @Override
  public boolean hasVisited(String restaurantId, String userId) {
    return false;
  }

  @Override
  public boolean hasNotRatedYet(String string, String string2) {
    return false;
  }

  @Override
  public List<Restaurant> findAll() {
    return null;
  }

}
