package co.hodler.controllers;

import co.hodler.actions.ProvideCoordinates;
import co.hodler.model.Coordinates;
import co.hodler.model.CoordinatesDto;
import spark.Request;

public class CoordinatesController {

  private ProvideCoordinates provideCoords;
  private CoordinatesDto coordinatesDto;

  public CoordinatesController(ProvideCoordinates provideCoords, CoordinatesDto coordinatesDto) {
    this.provideCoords = provideCoords;
    this.coordinatesDto = coordinatesDto;
  }

  public String requestCoords(Request request, Object object) {
    String address = request.queryParams("address");
    Coordinates coords = provideCoords.fetchCoordinatesFor(address);
    return coordinatesDto.toJson(coords);
  }

}
