package co.hodler.actions;

import co.hodler.infrastructure.RestaurantRepository;
import co.hodler.model.Visit;

public class VisitRestaurant {

  private RestaurantRepository restaurantRepo;

  public VisitRestaurant(RestaurantRepository restaurantRepo) {
    this.restaurantRepo = restaurantRepo;
  }

  public void visit(Visit visit) {
    restaurantRepo.addVisitorFor(visit);
  }

}
