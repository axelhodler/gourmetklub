package co.hodler.infrastructure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eclipsesource.json.JsonArray;

public class JsonReader {

  public static String jsonArrayAsString(String jsonFile) {
    return jsonArray(jsonFile).toString();
  }

  private static JsonArray jsonArray(String jsonFile) {
    JsonArray array = null;
    try {
      array = JsonArray
          .readFrom(new InputStreamReader(new FileInputStream("./src/main/webapp/data/restaurants.json"), "UTF-8"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return array;
  }
}
