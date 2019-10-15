package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Reports;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface ReportsRepository extends CrudRepository<Reports, Integer> {
    Optional<Reports> findById(Long id);
    Collection<Reports> findByUser(User user);
    Reports findOneByUserAndId(User user, long id);
}
