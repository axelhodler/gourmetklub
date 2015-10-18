package co.hodler.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.actions.ProvideCoordinates;
import co.hodler.model.Coordinates;
import co.hodler.model.CoordinatesDto;
import spark.Request;

@RunWith(MockitoJUnitRunner.class)
public class CoordinatesControllerShould {

  @Mock
  ProvideCoordinates provideCoords;
  @Mock
  CoordinatesDto coordinatesDto;
  @Mock
  Request request;

  @Test
  public void provideCoordinates() {
    Coordinates coords = new Coordinates("4.2", "4.2");
    given(request.queryParams("address")).willReturn("someaddress");
    given(provideCoords.fetchCoordinatesFor("someaddress")).willReturn(coords);
    given(coordinatesDto.toJson(coords)).willReturn("{\"lat\":\"4.2\",\"lng\":\"4.2\"}");
    CoordinatesController coordController = new CoordinatesController(provideCoords, coordinatesDto);

    String coordsAsJson = coordController.requestCoords(request, null);

    assertThat(coordsAsJson, is("{\"lat\":\"4.2\",\"lng\":\"4.2\"}"));
  }
}
