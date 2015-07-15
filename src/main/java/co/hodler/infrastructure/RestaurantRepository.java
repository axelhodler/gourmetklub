package co.hodler.infrastructure;

import java.util.List;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;

public interface RestaurantRepository {

  public void persist(Restaurant r);

  public void addVisitorFor(String restaurantId, String userId);

  public void rate(Rating rating);

  public boolean hasVisited(String restaurantId, String userId);

  public boolean hasNotRatedYet(String string, String string2);

  public List<Restaurant> findAll();
}
