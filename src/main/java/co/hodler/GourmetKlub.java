package co.hodler;

import static spark.Spark.get;

public class GourmetKlub {
  public static void main(String[] args) {
    get("/hello", (req, res) -> "Hello World");
  }
}
