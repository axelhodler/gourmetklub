package co.hodler.model;

import com.eclipsesource.json.JsonObject;

public class CoordinatesDto {

  public String toJson(Coordinates coords) {
    JsonObject jo = new JsonObject();
    jo.add("lat", coords.getLat());
    jo.add("lng", coords.getLng());
    return jo.toString();
  }
}
