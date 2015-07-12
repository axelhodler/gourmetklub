package co.hodler.actions;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.RestaurantRepository;

@RunWith(MockitoJUnitRunner.class)
public class RateRestaurantShould {

  @Mock
  RestaurantRepository restaurantRepository;

  @Test
  public void check_if_user_has_visited_restaurant() {
    RateRestaurant rateRestaurant = new RateRestaurant(restaurantRepository);

    rateRestaurant.rate("restaurantId", "userId", "rating");

    verify(restaurantRepository).rate("restaurantId", "userId", "rating");
  }
}
