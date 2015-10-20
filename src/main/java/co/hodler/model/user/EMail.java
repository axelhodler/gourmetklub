package co.hodler.model.user;

public class EMail {

  private String mailAddress;

  public EMail(String mailAddress) {
    if(!mailAddress.contains("@") || !mailAddress.contains("."))
      throw new RuntimeException("not a valid email");
    else
      this.mailAddress = mailAddress;
  }

  public String value() {
    return this.mailAddress;
  }
}
