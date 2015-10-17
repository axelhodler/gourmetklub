package co.hodler.infrastructure;

import static co.hodler.infrastructure.Throwables.executeQuery;

import java.io.FileReader;

import com.eclipsesource.json.JsonObject;

public class JsonReader {

  public static String jsonObjectAsString(String jsonFile) {
    return jsonObject(jsonFile).toString();
  }

  private static JsonObject jsonObject(String jsonFile) {
    return executeQuery(() -> JsonObject.readFrom(new FileReader(jsonFile)));
  }
}
