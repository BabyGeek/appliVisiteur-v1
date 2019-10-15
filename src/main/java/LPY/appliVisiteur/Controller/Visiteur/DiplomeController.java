package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Diplomas;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DiplomaRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DiplomaView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiplomeController extends BaseController {
    @Autowired
    private DiplomaRepository diplomaRepository;

    @RequestMapping(value = "diplome/{id}", method = RequestMethod.GET)
    public String getDiplome(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Diplomas diplomas = diplomaRepository.findOneById(id);
        if (diplomas == null)
        {
            throw new RessouceNotFoundExeption("diplome not found");
        }
        return this.createResponse(diplomaRepository.findOneById(id), DiplomaView.Diploma.class);
    }

    @RequestMapping(value = "diplomes", method = RequestMethod.GET)
    public String getDiplomes() throws JsonProcessingException {
        return this.createResponse(diplomaRepository.findAll(), DiplomaView.Diploma.class);
    }
}
