package co.hodler.infrastructure.external;

import static co.hodler.infrastructure.Throwables.executeQuery;

import com.mashape.unirest.http.Unirest;
public class GoogleMapsCoordinatesProvider implements CoordinatesProvider {

  @Override
  public String fetchCoordinatesFor(String address) {
    return executeQuery(() -> Unirest.get("http://maps.google.com/maps/api/geocode/json")
        .queryString("address", address).asJson()
        .getBody().getObject().getJSONArray("results").getJSONObject(0)
        .getJSONObject("geometry").getJSONObject("location").toString());
  }

}
