package co.hodler.actions;

import co.hodler.infrastructure.RestaurantRepository;

public class VisitRestaurant {

  private RestaurantRepository restaurantRepo;

  public VisitRestaurant(RestaurantRepository restaurantRepo) {
    this.restaurantRepo = restaurantRepo;
  }

  public void visit(String restaurantId, String userId) {
    restaurantRepo.addVisitorFor(restaurantId, userId);
  }

}
