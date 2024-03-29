package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
    @Transactional
    Optional<User> findById(long id);
}