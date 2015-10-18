package co.hodler.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CoordinatesDtoShould {

  @Test
  public void transformObjectToJsonString() {
    Coordinates coords = new Coordinates("34.234", "8.23");

    CoordinatesDto dto = new CoordinatesDto();

    assertThat(dto.toJson(coords), is("{\"lat\":\"34.234\",\"lng\":\"8.23\"}"));
  }
}
