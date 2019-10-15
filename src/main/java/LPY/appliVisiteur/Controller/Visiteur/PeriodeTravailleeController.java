package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.workedTimes;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.WorkedTimesRepository;
import LPY.appliVisiteur.Model.View.Visiteur.WorkingTimeView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PeriodeTravailleeController extends BaseController {
    @Autowired
    private WorkedTimesRepository workedTimesRepository;

    @RequestMapping(value = "periodeTravaillee/{id}", method = RequestMethod.GET)
    public String getDepartement(@PathVariable("id") Long id) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
        workedTimes workedTimes = workedTimesRepository.findByIdAndUser(id, this.getUser());
        if (workedTimes == null)
        {
            throw new RessouceNotFoundExeption("periodeTravaille not found");
        }
        else
        {
            return this.createResponse(workedTimes, WorkingTimeView.WorkingTime.class);
        }
    }

    @RequestMapping(value = "periodeTravaillees", method = RequestMethod.GET)
    public String getPeriodeTravaillees() throws UserNotFoundException, JsonProcessingException {
        User user = this.getUser();
        Collection<workedTimes> workedTimes = workedTimesRepository.findByUser(user);
        return this.createResponse(workedTimes, WorkingTimeView.WorkingTime.class);
    }
}
