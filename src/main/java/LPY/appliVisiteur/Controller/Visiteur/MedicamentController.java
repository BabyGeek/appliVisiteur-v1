package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Drugs;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DrugsRepository;
import LPY.appliVisiteur.Model.View.Visiteur.MedicamentView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicamentController extends BaseController {
    @Autowired
    private DrugsRepository drugsRepository;

    @RequestMapping(value = "medicament/{id}", method = RequestMethod.GET)
    public String getDepartement(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Drugs drugs = drugsRepository.findOneById(id);
        if (drugs == null)
        {
            throw new RessouceNotFoundExeption("medicament not found");
        }
        return createResponse(drugs, MedicamentView.Medicament.class);
    }

    @RequestMapping(value = "medicaments", method = RequestMethod.GET)
    public String getMedicaments() throws JsonProcessingException {
        return createResponse(drugsRepository.findAll(),MedicamentView.Medicament.class);
    }
}
