package co.hodler.model.user;

public class Credentials {

  private EMail mailAddress;
  private HashedPassword hashedPassword;

  public Credentials(EMail mailAddress, HashedPassword hashedPassword) {
    this.mailAddress = mailAddress;
    this.hashedPassword = hashedPassword;
  }

  public String getMailAddress() {
    return mailAddress.value();
  }

  public String getHashedPassword() {
    return hashedPassword.value();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((hashedPassword == null) ? 0 : hashedPassword.hashCode());
    result = prime * result
        + ((mailAddress == null) ? 0 : mailAddress.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Credentials other = (Credentials) obj;
    if (hashedPassword == null) {
      if (other.hashedPassword != null)
        return false;
    } else if (!hashedPassword.equals(other.hashedPassword))
      return false;
    if (mailAddress == null) {
      if (other.mailAddress != null)
        return false;
    } else if (!mailAddress.equals(other.mailAddress))
      return false;
    return true;
  }

}
