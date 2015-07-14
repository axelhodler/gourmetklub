package co.hodler.infrastructure;

import java.util.List;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;

public class RestaurantRepository {

  public void persist(Restaurant r) {

  }

  public void addVisitorFor(String restaurantId, String userUuid) {
    
  }

  public void rate(Rating rating) {

  }

  public boolean hasVisited(String restaurantId, String userId) {
    return false;
  }

  public boolean hasNotRatedYet(String string, String string2) {
    return false;
  }

  public List<Restaurant> findAll() {
    return null;
  }

}
