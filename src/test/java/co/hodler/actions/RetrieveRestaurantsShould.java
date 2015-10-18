package co.hodler.actions;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.repositories.RestaurantRepository;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveRestaurantsShould {

  @Mock
  RestaurantRepository restaurantRepo;

  @Test
  public void fetchAllRestaurants() {
    RetrieveRestaurants rr = new RetrieveRestaurants(restaurantRepo);

    rr.all();

    verify(restaurantRepo).findAll();
  }
}
