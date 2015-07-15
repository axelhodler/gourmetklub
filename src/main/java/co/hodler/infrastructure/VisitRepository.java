package co.hodler.infrastructure;

import co.hodler.model.Visit;

public interface VisitRepository {

  public boolean exists(Visit visit);
  
  public boolean isRated(Visit visit);

  public void persist(Visit visit);
}
