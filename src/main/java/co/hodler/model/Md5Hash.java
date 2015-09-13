package co.hodler.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Hash {

  private String toHash;

  public Md5Hash(String toHash) {
    this.toHash = toHash;
  }

  public String value() {
    byte[] digest = createMd5MessageDigest().digest(toHash.getBytes());

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < digest.length; i++) {
      sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }

  private MessageDigest createMd5MessageDigest() {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return md;
  }
}