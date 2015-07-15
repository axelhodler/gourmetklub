package co.hodler.infrastructure;

import java.util.List;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;
import co.hodler.model.Visit;

public interface RestaurantRepository {

  public void persist(Restaurant r);

  public void addVisitorFor(Visit visit);

  public void rate(Rating rating);

  public boolean hasVisited(Visit visit);

  public boolean hasNotRatedYet(Visit visit);

  public List<Restaurant> findAll();
}
