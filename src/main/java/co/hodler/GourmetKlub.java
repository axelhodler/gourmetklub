package co.hodler;

import static spark.Spark.get;
import static co.hodler.infrastructure.JsonReader.*;

public class GourmetKlub {
  public static void main(String[] args) {
    get("/restaurants", (req, res) -> jsonArrayAsString("./src/main/webapp/data/restaurants.json"));
  }
}
