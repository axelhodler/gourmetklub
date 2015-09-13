package co.hodler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.dalesbred.Database;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.hodler.infrastructure.DefaultRestaurantRepository;
import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Coordinates;
import co.hodler.model.Restaurant;

public class DefaultRestaurantRepositoryIT {

  private Database db;
  private RestaurantRepository restaurantRepo;

  @Before
  public void setUp() throws Exception {
    InMemoryDbSetup dbSetup = new InMemoryDbSetup();
    db = dbSetup.initDatabaseByUrl();

    db.update("CREATE TABLE restaurant (id INT NOT NULL AUTO_INCREMENT,"
                                      + "name VARCHAR(50),"
                                      + "pickerId INT,"
                                      + "latitude VARCHAR(50),"
                                      + "longitude VARCHAR(50));");

    restaurantRepo = new DefaultRestaurantRepository(db);
  }

  @After
  public void tearDown() {
    db.update("DROP TABLE restaurant");
  }

  @Test
  public void can_store_restaurant_with_coordinates() throws Exception {
    Restaurant restaurant = new Restaurant("First", 1);
    restaurant.setCoordinates(new Coordinates("50", "10"));

    restaurantRepo.persist(restaurant);

    List<Restaurant> allRestaurants = restaurantRepo.findAll();
    assertThat(allRestaurants.get(0).getCoordinates().getLat(), equalTo("50"));
    assertThat(allRestaurants.get(0).getCoordinates().getLng(), equalTo("10"));
  }

  @Test
  public void can_retrieve_all_restaurants() {
    Restaurant first = new Restaurant("First", 1);
    Restaurant second = new Restaurant("First", 2);
    restaurantRepo.persist(first);
    restaurantRepo.persist(second);

    List<Restaurant> allRestaurants = restaurantRepo.findAll();

    assertThat(allRestaurants.size(), is(2));
    assertThat(allRestaurants.get(1).getName(), equalTo("First"));
  }
}
