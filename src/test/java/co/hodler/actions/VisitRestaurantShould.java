package co.hodler.actions;

import org.junit.Test;

import co.hodler.model.User;

public class VisitRestaurantShould {

  @Test
  public void add_visitor_to_restaurant() {
    VisitRestaurant vr = new VisitRestaurant();
    User u = new User();

    vr.visit("name", u);
  }
}
