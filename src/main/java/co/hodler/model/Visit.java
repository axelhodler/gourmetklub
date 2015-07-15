package co.hodler.model;

public class Visit {

  private String restaurantId;
  private String userId;

  public Visit(String restaurantId, String userId) {
    this.restaurantId = restaurantId;
    this.userId = userId;
  }

  public String getRestaurantId() {
    return restaurantId;
  }

  public String getUserId() {
    return userId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((restaurantId == null) ? 0 : restaurantId.hashCode());
    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Visit other = (Visit) obj;
    if (restaurantId == null) {
      if (other.restaurantId != null)
        return false;
    } else if (!restaurantId.equals(other.restaurantId))
      return false;
    if (userId == null) {
      if (other.userId != null)
        return false;
    } else if (!userId.equals(other.userId))
      return false;
    return true;
  }

}
