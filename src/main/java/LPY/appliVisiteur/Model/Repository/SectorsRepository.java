package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Sectors;
import org.springframework.data.repository.CrudRepository;

public interface SectorsRepository extends CrudRepository<Sectors, Integer>
{
    Sectors findOneById(Long id);
}
