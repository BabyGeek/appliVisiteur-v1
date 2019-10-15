package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Pratitionners;
import org.springframework.data.repository.CrudRepository;

public interface PratitionnersRepository extends CrudRepository<Pratitionners, Integer> {
    Pratitionners findOneById(Long id);
}
