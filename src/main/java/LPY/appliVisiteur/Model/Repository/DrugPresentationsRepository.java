package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.DrugPresentations;
import org.springframework.data.repository.CrudRepository;

public interface DrugPresentationsRepository extends CrudRepository<DrugPresentations, Integer> {
    DrugPresentations findOneById(Long id);
}
