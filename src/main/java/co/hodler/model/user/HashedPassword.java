package co.hodler.model.user;

public class HashedPassword {

  private String password;

  public HashedPassword(String password) {
    this.password = password;
  }

  public String value() {
    return new Md5Hash(password).value();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((password == null) ? 0 : password.hashCode());
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
    HashedPassword other = (HashedPassword) obj;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    return true;
  }

}
