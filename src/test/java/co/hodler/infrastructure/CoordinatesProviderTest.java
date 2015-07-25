package co.hodler.infrastructure;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CoordinatesProviderTest {

  @Test
  public void providesCoordinatesForAddress() {
    CoordinatesProvider coordProvider = new CoordinatesProvider();

    Coordinates coords = coordProvider.fetchCoordinatesFor("Schwabstrasse 100 Stuttgart");

    assertThat(coords.getLng(), is("48.7792446"));
    assertThat(coords.getLat(), is("9.1562375"));
  }
}
