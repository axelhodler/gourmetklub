package co.hodler.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashedPassword {

  private String password;

  public HashedPassword(String password) {
    this.password = password;
  }

  public String value() {
    String hashedPassword = null;

    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] digest = md.digest(password.getBytes());
      
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < digest.length; i++) {
       sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
      }
      hashedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return hashedPassword; 
  }
}
