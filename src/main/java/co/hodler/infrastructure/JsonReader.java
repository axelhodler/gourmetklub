package co.hodler.infrastructure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eclipsesource.json.JsonObject;

public class JsonReader {

  public static String jsonObjectAsString(String jsonFile) {
    return jsonObject(jsonFile).toString();
  }

  private static JsonObject jsonObject(String jsonFile) {
    JsonObject array = null;
    try {
      array = JsonObject
          .readFrom(new InputStreamReader(new FileInputStream("./src/main/webapp/data/restaurants.json"), "UTF-8"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return array;
  }
}
