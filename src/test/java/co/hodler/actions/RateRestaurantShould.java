package co.hodler.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Rating;

@RunWith(MockitoJUnitRunner.class)
public class RateRestaurantShould {

  @Mock
  RestaurantRepository restaurantRepository;

  @Test
  public void check_if_user_has_visited_restaurant() {
    RateRestaurant rateRestaurant = new RateRestaurant(restaurantRepository);
    Rating rating = new Rating("restaurantId", "userId", "rating");

    rateRestaurant.rate(rating);

    verify(restaurantRepository).hasVisited("restaurantId", "userId");
  }

  @Test
  public void only_rate_if_user_has_visited_restaurant() {
    RateRestaurant rateRestaurant = new RateRestaurant(restaurantRepository);
    Rating rating = new Rating("restaurantId", "userId", "rating");
    given(restaurantRepository.hasVisited("restaurantId", "userId")).willReturn(true);

    rateRestaurant.rate(rating);

    verify(restaurantRepository).rate(rating);
  }
}
