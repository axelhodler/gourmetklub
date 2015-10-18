package co.hodler;

import org.junit.Test;

import co.hodler.actions.ProvideCoordinates;
import co.hodler.model.Coordinates;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CoordinatesProviderIT {

  @Test
  public void providesCoordinatesForAddress() {
    ProvideCoordinates coordProvider = new ProvideCoordinates();

    Coordinates coords = coordProvider.fetchCoordinatesFor("Schwabstrasse 100 Stuttgart");

    assertThat(coords.getLng(), is("48.7792446"));
    assertThat(coords.getLat(), is("9.1562375"));
  }
}
