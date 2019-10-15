package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Sectors;
import LPY.appliVisiteur.Model.Repository.SectorsRepository;
import LPY.appliVisiteur.Model.View.Visiteur.SecteurView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecteurController extends BaseController {
    @Autowired
    private SectorsRepository sectorsRepository;

    @RequestMapping(value = "secteur/{id}", method = RequestMethod.GET)
    public String getSecteur(@PathVariable("id") Long id) throws JsonProcessingException {
        Sectors sectors = sectorsRepository.findOneById(id);
        return createResponse(sectors, SecteurView.Secteur.class);
    }

    @RequestMapping(value = "secteurs", method = RequestMethod.GET)
    public String getSecteurs() throws JsonProcessingException {
        return createResponse(sectorsRepository.findAll(), SecteurView.Secteur.class);
    }
}
