package co.hodler.model;

import static com.eclipsesource.json.JsonObject.readFrom;

import com.eclipsesource.json.JsonObject;

import co.hodler.model.user.HashedPassword;
import co.hodler.model.user.User;

public class UserDto {

  public User fromJson(String userJson) {
    JsonObject jo = readFrom(userJson);

    return new User(jo.get("name").asString(),
                    jo.get("mail").asString(),
                    new HashedPassword(jo.get("password").asString()));
  }

}
