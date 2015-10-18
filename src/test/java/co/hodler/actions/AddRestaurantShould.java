package co.hodler.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.repositories.RestaurantRepository;
import co.hodler.model.Coordinates;
import co.hodler.model.Restaurant;

@RunWith(MockitoJUnitRunner.class)
public class AddRestaurantShould {

  @Mock
  RestaurantRepository repository;
  @Mock
  ProvideCoordinates coordinatesProvider;

  private AddRestaurant addRestaurant;

  @Before
  public void setUp() {
    addRestaurant = new AddRestaurant(repository, coordinatesProvider);

    given(coordinatesProvider
            .fetchCoordinatesFor("Schwabstrasse 100 Stuttgart"))
            .willReturn(new Coordinates("50", "9"));
  }

  @Test
  public void set_coordinates_of_the_restaurant() {
    Restaurant r = new Restaurant("name", 2);
    r.setAddress("Schwabstrasse 100 Stuttgart");

    addRestaurant.add(r);

    verify(repository).persist(r);
  }
}
