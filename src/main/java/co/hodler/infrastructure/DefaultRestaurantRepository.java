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
  public void addVisitorFor(Visit visit) {

  }

  @Override
  public void rate(Rating rating) {

  }

  @Override
  public boolean hasVisited(Visit visit) {
    return false;
  }

  @Override
  public boolean hasNotRatedYet(Visit visit) {
    return false;
  }

  @Override
  public List<Restaurant> findAll() {
    return null;
  }

}
