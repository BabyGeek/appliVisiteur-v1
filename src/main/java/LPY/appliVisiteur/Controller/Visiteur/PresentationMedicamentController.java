package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.DrugPresentations;
import LPY.appliVisiteur.Model.Entity.Drugs;
import LPY.appliVisiteur.Model.Entity.Reports;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.DrugsRepository;
import LPY.appliVisiteur.Model.Repository.PratitionnersRepository;
import LPY.appliVisiteur.Model.Repository.DrugPresentationsRepository;
import LPY.appliVisiteur.Model.Repository.ReportsRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.PresentationMedicamentBody;
import LPY.appliVisiteur.Model.View.Visiteur.DrugPresentationView;
import LPY.appliVisiteur.Model.View.Visiteur.VisitReportView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PresentationMedicamentController extends BaseController {
    @Autowired
    private ReportsRepository reportsRepository;

    @Autowired
    private DrugsRepository drugsRepository;

    @Autowired
    private PratitionnersRepository pratitionnersRepository;

    @Autowired
    private DrugPresentationsRepository drugPresentationsRepository;

    @RequestMapping(value = "presentationMedicament", method = RequestMethod.POST)
    public String patchMedicament(@RequestBody PresentationMedicamentBody presentationMedicamentBody)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        Reports reports = reportsRepository.findOneByUserAndId(this.getUser(),presentationMedicamentBody.getIdRapportVisite());
        Drugs drugs = drugsRepository.findOneById(presentationMedicamentBody.getIdMedicament());
        if (reports == null || drugs == null)
        {
            throw new RessouceNotFoundExeption("rapport visite or medicament not found");
        }
        else
        {
            DrugPresentations drugPresentations = new DrugPresentations();
            drugPresentations.setReports(reports);
            drugPresentations.setDrugs(drugs);
            reports.getDrugPresentations().add(drugPresentations);
            drugPresentationsRepository.save(drugPresentations);
            return this.createResponse(reports, VisitReportView.VisitReport.class);
        }
    }

    @RequestMapping(value = "presentationMedicament/{idPresentationMedicament}", method = RequestMethod.DELETE)
    public String deleteMedicament(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        DrugPresentations drugPresentations = drugPresentationsRepository.findOneById(idPresentationMedicament);
        if (drugPresentations == null)
        {
            throw new RessouceNotFoundExeption("presentation medicament not found");
        }
        else
        {
            drugPresentationsRepository.delete(drugPresentations);
            return this.createResponse(drugPresentations.getReports(), VisitReportView.VisitReport.class);
        }

    }

    @RequestMapping(value = "presentationMedicament/{idPresentationMedicament}", method = RequestMethod.GET)
    public String getMedicament(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        DrugPresentations drugPresentations = drugPresentationsRepository.findOneById(idPresentationMedicament);
        if (drugPresentations == null)
        {
            throw new RessouceNotFoundExeption("presentation medicament not found");
        }
        else
        {
            return this.createResponse(drugPresentations, DrugPresentationView.DrugPresentation.class);
        }

    }
}
