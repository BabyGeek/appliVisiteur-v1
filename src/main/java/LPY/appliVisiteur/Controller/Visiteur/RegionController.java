package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Regions;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.RegionsRepository;
import LPY.appliVisiteur.Model.View.Visiteur.RegionView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionController extends BaseController {
    @Autowired
    private RegionsRepository regionsRepository;

    @RequestMapping(value = "region/{id}", method = RequestMethod.GET)
    public String getRegion(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Regions regions = regionsRepository.findOneById(id);
        if(regions == null)
        {
            throw new RessouceNotFoundExeption("region not found");
        }
        return createResponse(regions, RegionView.Region.class);
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    public String getRegions() throws JsonProcessingException {
        return createResponse(regionsRepository.findAll(), RegionView.Region.class);
    }
}
