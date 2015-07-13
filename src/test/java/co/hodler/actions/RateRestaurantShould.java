package co.hodler.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Rating;
import co.hodler.model.stars.OneStar;

@RunWith(MockitoJUnitRunner.class)
public class RateRestaurantShould {

  @Mock
  RestaurantRepository restaurantRepository;

  private RateRestaurant rateRestaurant;
  private Rating rating;

  @Before
  public void setUp() {
    rateRestaurant = new RateRestaurant(restaurantRepository);
    rating = new Rating("restaurantId", "userId", new OneStar());
  }

  @Test
  public void check_if_user_has_visited_restaurant() {
    given(restaurantRepository.hasVisited("restaurantId", "userId")).willReturn(false);

    rateRestaurant.rate(rating);

    verify(restaurantRepository, never()).rate(rating);
  }

  @Test
  public void only_rate_if_user_has_visited_restaurant() {
    given(restaurantRepository.hasVisited("restaurantId", "userId")).willReturn(true);
    given(restaurantRepository.hasNotRatedYet("restaurantId", "userId")).willReturn(true);

    rateRestaurant.rate(rating);

    verify(restaurantRepository).rate(rating);
  }

  @Test
  public void only_rate_if_user_has_not_yet_rated() {
    given(restaurantRepository.hasVisited("restaurantId", "userId")).willReturn(true);

    rateRestaurant.rate(rating);

    verify(restaurantRepository).hasNotRatedYet("restaurantId", "userId");
  }
}
