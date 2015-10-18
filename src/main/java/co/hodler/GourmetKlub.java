package co.hodler;

import static spark.Spark.get;

import co.hodler.actions.ProvideCoordinates;
import co.hodler.controllers.CoordinatesController;
import co.hodler.infrastructure.external.GoogleMapsCoordinatesProvider;
import co.hodler.model.CoordinatesDto;
import spark.Spark;

import static co.hodler.infrastructure.JsonReader.*;

public class GourmetKlub {
  public static void main(String[] args) {
    Spark.port(Integer.valueOf(System.getenv("PORT")));

    get("/restaurants", (req, res) -> {
      res.header("Access-Control-Allow-Origin", "*");
      return jsonObjectAsString("./src/main/webapp/data/restaurants.json");
    });

    get("/coordinates", (req, res) -> {
      ProvideCoordinates provideCoordinates = new ProvideCoordinates(new GoogleMapsCoordinatesProvider());
      CoordinatesController controller = new CoordinatesController(provideCoordinates, new CoordinatesDto());
      return controller.requestCoords(req, res);
    });
  }
}
