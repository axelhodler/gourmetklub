package co.hodler.actions;

import static com.eclipsesource.json.JsonObject.readFrom;

import com.eclipsesource.json.JsonObject;

import co.hodler.infrastructure.external.CoordinatesProvider;
import co.hodler.model.Coordinates;
public class ProvideCoordinates {

  private CoordinatesProvider coordinatesProvider;

  public ProvideCoordinates(CoordinatesProvider coordinatesProvider) {
    this.coordinatesProvider = coordinatesProvider;
  }

  public Coordinates fetchCoordinatesFor(String address) {
    String coordinatesJson = coordinatesProvider.fetchCoordinatesFor(address);
    JsonObject coordinates = readFrom(coordinatesJson);

    return new Coordinates(coordinates.get("lat").toString(),
        coordinates.get("lng").toString());
  }

}
