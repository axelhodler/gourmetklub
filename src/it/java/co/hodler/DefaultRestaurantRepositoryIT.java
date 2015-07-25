package co.hodler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.dalesbred.Database;
import org.junit.Before;
import org.junit.Test;

import co.hodler.infrastructure.DefaultRestaurantRepository;
import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Restaurant;

public class DefaultRestaurantRepositoryIT {

  private Database db;
  private RestaurantRepository restaurantRepo;

  @Before
  public void setUp() {
    initInmemoryDb();
    db = Database.forUrlAndCredentials("jdbc:h2:mem:test", "", "");
    db.update("CREATE TABLE restaurant (id INT NOT NULL AUTO_INCREMENT,"
                                      + "name VARCHAR(50),"
                                      + "pickerId INT);");

    restaurantRepo = new DefaultRestaurantRepository(db);
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

  private void initInmemoryDb() {
    try {
      Class.forName("org.h2.Driver");
      DriverManager.getConnection("jdbc:h2:mem:test", "", "");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
