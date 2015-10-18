package co.hodler.actions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.hodler.infrastructure.external.CoordinatesProvider;
import co.hodler.model.Coordinates;

@RunWith(MockitoJUnitRunner.class)
public class ProvideCoordinatesShould {

  @Mock
  CoordinatesProvider coordProvider;

  @Test
  public void provideCoordinatesForAddresses() {
    given(coordProvider.fetchCoordinatesFor("some street 10 some city"))
        .willReturn("{\"lng\":9.1562375,\"lat\":48.7792446}");
    ProvideCoordinates provideCoordinates = new ProvideCoordinates(coordProvider);

    Coordinates coords = provideCoordinates.fetchCoordinatesFor("some street 10 some city");
    assertThat(coords.getLat(), is("48.7792446"));
    assertThat(coords.getLng(), is("9.1562375"));
  }
}
