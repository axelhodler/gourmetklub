package co.hodler.actions;

import co.hodler.infrastructure.repositories.VisitRepository;
import co.hodler.model.Visit;

public class VisitRestaurant {

  private VisitRepository visitRepository;

  public VisitRestaurant(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  public void visit(Visit visit) {
    visitRepository.persist(visit);
  }

}
