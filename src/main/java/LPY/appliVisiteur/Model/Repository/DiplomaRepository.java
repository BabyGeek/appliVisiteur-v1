package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Diplomas;
import org.springframework.data.repository.CrudRepository;

public interface DiplomaRepository extends CrudRepository<Diplomas, Integer> {
    Diplomas findOneById(Long id);
}
