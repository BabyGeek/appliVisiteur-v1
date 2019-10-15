package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Departments;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DepartmentsRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DepartmentView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartementController extends BaseController {
    @Autowired
    private DepartmentsRepository departmentsRepository;

    @RequestMapping(value = "departement/{id}", method = RequestMethod.GET)
    public String getDepartement(@PathVariable("id") long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Departments departments = departmentsRepository.findOneById(id);
        if (departments == null)
        {
            throw new RessouceNotFoundExeption("departement not found");
        }
        return this.createResponse(departments, DepartmentView.Department.class);
    }

    @RequestMapping(value = "departements", method = RequestMethod.GET)
    public String getDepartements() throws JsonProcessingException {
        return this.createResponse(departmentsRepository.findAll(), DepartmentView.Department.class);
    }
}
