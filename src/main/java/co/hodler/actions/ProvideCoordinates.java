package co.hodler.actions;

import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import co.hodler.model.Coordinates;

public class ProvideCoordinates {

  public Coordinates fetchCoordinatesFor(String address) {
    JSONObject location = null;
    try {
      location = Unirest.get("http://maps.google.com/maps/api/geocode/json")
          .queryString("address", "Schwabstrasse 100 Stuttgart").asJson()
          .getBody().getObject().getJSONArray("results").getJSONObject(0)
          .getJSONObject("geometry").getJSONObject("location");
    } catch (JSONException | UnirestException e) {
      e.printStackTrace();
    }
    return new Coordinates(location.get("lng").toString(),
        location.get("lat").toString());
  }

}
