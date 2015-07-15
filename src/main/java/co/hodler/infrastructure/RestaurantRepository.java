package co.hodler.infrastructure;

import java.util.List;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;
import co.hodler.model.Visit;

public interface RestaurantRepository {

  public void persist(Restaurant r);

  public void persist(Visit visit);

  public void persist(Rating rating);

  public boolean exists(Visit visit);

  public boolean isRated(Visit visit);

  public List<Restaurant> findAll();
}
