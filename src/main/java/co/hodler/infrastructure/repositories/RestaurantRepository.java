package co.hodler.infrastructure.repositories;

import java.util.List;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;

public interface RestaurantRepository {

  public void persist(Restaurant r);

  public void persist(Rating rating);

  public List<Restaurant> findAll();
}
