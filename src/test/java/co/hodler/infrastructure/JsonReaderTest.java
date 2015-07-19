package co.hodler.infrastructure;

import static org.junit.Assert.*;

import org.junit.Test;
import static co.hodler.infrastructure.JsonReader.*;

public class JsonReaderTest {

  @Test
  public void dealsWithUmlauts() {
    String restaurants = jsonArrayAsString("./src/main/webapp/data/restaurants.json");

    assertTrue(restaurants.contains("Tü"));
  }
}
