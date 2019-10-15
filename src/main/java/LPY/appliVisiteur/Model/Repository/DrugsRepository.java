package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Drugs;
import org.springframework.data.repository.CrudRepository;

public interface DrugsRepository extends CrudRepository<Drugs, Integer> {
    Drugs findOneById(Long id);
}
