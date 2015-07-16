package co.hodler.infrastructure;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.dalesbred.Database;
import org.junit.Before;
import org.junit.Test;

import co.hodler.model.Restaurant;

public class DefaultRestaurantRepositoryTest {

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
  public void can_persist_restaurant() {
    Restaurant r = new Restaurant("Traube", 1);
    restaurantRepo.persist(r);

    Restaurant onlyRestaurant = db.findUnique(Restaurant.class, "SELECT * FROM restaurant WHERE id = ?", 1);

    assertThat(onlyRestaurant.getId(), equalTo(1));
    assertThat(onlyRestaurant.getName(), equalTo("Traube"));
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
