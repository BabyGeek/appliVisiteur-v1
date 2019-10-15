package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Regions;
import org.springframework.data.repository.CrudRepository;

public interface RegionsRepository extends CrudRepository<Regions, Integer> {
    Regions findOneById(Long id);
}
