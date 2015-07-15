package co.hodler.actions;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Visit;

@RunWith(MockitoJUnitRunner.class)
public class VisitRestaurantShould {

  @Mock
  RestaurantRepository restaurantRepo;

  @Test
  public void add_visitor_to_restaurant() {
    VisitRestaurant vr = new VisitRestaurant(restaurantRepo);

    vr.visit(new Visit("restaurantId", "userId"));

    verify(restaurantRepo).persist(new Visit("restaurantId", "userId"));
  }
}
