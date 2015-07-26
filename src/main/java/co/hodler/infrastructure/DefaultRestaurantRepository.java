package co.hodler.infrastructure;

import java.util.List;

import org.dalesbred.Database;

import co.hodler.model.Rating;
import co.hodler.model.Restaurant;

public class DefaultRestaurantRepository implements RestaurantRepository {

  private Database database;

  public DefaultRestaurantRepository(Database db) {
    this.database = db;
  }

  @Override
  public void persist(Restaurant r) {
    database.update("INSERT INTO restaurant(name, pickerId, latitude, longitude) VALUES (?, ?, ?, ?);",
        r.getName(), r.getPickerId(), r.getCoordinates().getLat(), r.getCoordinates().getLng());
  }

  @Override
  public void persist(Rating rating) {

  }

  @Override
  public List<Restaurant> findAll() {
    return database.findAll(Restaurant.class, "SELECT * FROM restaurant");
  }

}
