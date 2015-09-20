package co.hodler.model;

import com.eclipsesource.json.JsonObject;

public class UserJson {

  private JsonObject jsonObject;

  public UserJson(JsonObject jsonObject) {
    this.jsonObject = jsonObject;
  }

  public User toUser() {
    return new User(jsonObject.get("name").asString(),
        jsonObject.get("mail").asString(),
        new HashedPassword(jsonObject.get("password").asString()));
  }
}
