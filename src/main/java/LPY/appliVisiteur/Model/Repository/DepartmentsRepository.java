package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Departments;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepository extends CrudRepository<Departments, Long> {
    Departments findOneById(Long id);
}
