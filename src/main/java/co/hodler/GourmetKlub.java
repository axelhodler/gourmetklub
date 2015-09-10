package co.hodler;

import static spark.Spark.get;

import spark.Spark;

import static co.hodler.infrastructure.JsonReader.*;

public class GourmetKlub {
  public static void main(String[] args) {
    Spark.port(Integer.valueOf(System.getenv("PORT")));

    get("/restaurants", (req, res) -> {
      res.header("Access-Control-Allow-Origin", "*");
      return jsonObjectAsString("./src/main/webapp/data/restaurants.json");
    });
  }
}
