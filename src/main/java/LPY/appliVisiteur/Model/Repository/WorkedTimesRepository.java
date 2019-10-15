package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.workedTimes;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface WorkedTimesRepository extends CrudRepository<workedTimes, Integer> {
    Optional<workedTimes> findById(long id);
    Collection<workedTimes>findByUser(User user);
    workedTimes findByIdAndUser(long id, User user);
}
