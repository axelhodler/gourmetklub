package co.hodler.actions;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Restaurant;

@RunWith(MockitoJUnitRunner.class)
public class AddRestaurantShould {

  @Mock
  RestaurantRepository repository;

  @Test
  public void set_user_who_picked_restaurant() {
    Restaurant r = new Restaurant("name", 1);

    AddRestaurant addRestaurant = new AddRestaurant(repository);
    addRestaurant.add(r);

    verify(repository).persist(r);
  }

}
