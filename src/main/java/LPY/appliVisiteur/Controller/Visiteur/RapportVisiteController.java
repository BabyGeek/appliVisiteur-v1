package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.*;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.DrugsRepository;
import LPY.appliVisiteur.Model.Repository.PratitionnersRepository;
import LPY.appliVisiteur.Model.Repository.DrugPresentationsRepository;
import LPY.appliVisiteur.Model.Repository.ReportsRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.RapportVisiteBody;
import LPY.appliVisiteur.Model.View.Visiteur.VisitReportView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class RapportVisiteController extends BaseController {
    @Autowired
    private ReportsRepository reportsRepository;

    @Autowired
    private DrugsRepository drugsRepository;

    @Autowired
    private PratitionnersRepository pratitionnersRepository;

    @Autowired
    private DrugPresentationsRepository drugPresentationsRepository;

    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.GET)
    public String getRapportVisite(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        Reports reports = reportsRepository.findOneByUserAndId(this.getUser(),id);
        if (reports == null)
        {
            throw new RessouceNotFoundExeption("rapport visite not found");
        }
        else
        {
            return this.createResponse(reports, VisitReportView.VisitReport.class);
        }

    }

    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.DELETE)
    public String deleteRapportVisite(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        Reports reports = reportsRepository.findOneByUserAndId(this.getUser(),id);
        if (reports == null)
        {
            throw new RessouceNotFoundExeption("rapport visite not found");
        }
        else
        {
            reportsRepository.delete(reports);
            return this.createResponse(this.getUser().getReports(), VisitReportView.VisitReport.class);
        }

    }

    @RequestMapping(value = "rapportVisites", method = RequestMethod.GET)
    public String getRapportVisites() throws UserNotFoundException, JsonProcessingException {
        User user = this.getUser();
        Collection<Reports> reports = reportsRepository.findByUser(user);
        return this.createResponse(reports, VisitReportView.VisitReport.class);
    }

    @RequestMapping(value = "rapportVisite", method = RequestMethod.POST)
    public String postRapportVisite(@RequestBody RapportVisiteBody rapportVisiteBody) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
        User user = this.getUser();
        Reports reports = new Reports();
        Collection<DrugPresentations> drugPresentations = new ArrayList<DrugPresentations>();
        for (Long medicamentId : rapportVisiteBody.getMedicamentId()) {
            Drugs drugs = drugsRepository.findOneById(medicamentId);
            if (drugs != null)
            {
                DrugPresentations drugPresentation = new DrugPresentations();
                drugPresentation.setDrugs(drugs)
                        .setReports(reports);
                drugPresentations.add(drugPresentation);
            }
            else
            {
                throw new RessouceNotFoundExeption("medicament not found");
            }
        }
        Pratitionners pratitionners = pratitionnersRepository.findOneById(rapportVisiteBody.getPraticienId());
        if (pratitionners != null)
        {
            reports.setPratitionners(pratitionners);
        }
        else
        {
            throw new RessouceNotFoundExeption("praticien not found");
        }

        reports.setUser(user);
        reports.setDrugPresentations(drugPresentations);
        reports.setNote(rapportVisiteBody.getNote());
        reportsRepository.save(reports);
        drugPresentationsRepository.saveAll(drugPresentations);
        return this.createResponse(reports, VisitReportView.VisitReport.class);
    }

    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.PATCH)
    public String patchRapportVisite(@PathVariable("id") Long id, @RequestBody RapportVisiteBody rapportVisiteBody) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        Reports reports = reportsRepository.findOneByUserAndId(this.getUser(),id);
        if (reports == null)
        {
            throw new RessouceNotFoundExeption("rapport visite not found");
        }
        else
        {
            if (rapportVisiteBody.getNote() != null)
            {
                reports.setNote(rapportVisiteBody.getNote());
            }
            reportsRepository.save(reports);
            return this.createResponse(reports, VisitReportView.VisitReport.class);
        }

    }
}
