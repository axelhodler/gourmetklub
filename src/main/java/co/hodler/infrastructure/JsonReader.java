package co.hodler.infrastructure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.eclipsesource.json.JsonObject;

public class JsonReader {

  public static String jsonObjectAsString(String jsonFile) {
    return jsonObject(jsonFile).toString();
  }

  private static JsonObject jsonObject(String jsonFile) {
    JsonObject array = null;
    try {
      array = JsonObject
          .readFrom(new FileReader(jsonFile));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return array;
  }
}
