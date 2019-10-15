package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.MedicamentView;
import LPY.appliVisiteur.Model.View.Visiteur.VisitReportView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Drugs {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({VisitReportView.VisitReport.class, MedicamentView.Medicament.class})
    private long id;

    @OneToMany(mappedBy = "drug")
    private Collection<DrugPresentations> drugPresentations;

    public Drugs()
    {
        drugPresentations = new ArrayList<DrugPresentations>();
    }

    public long getId() {
        return id;
    }

    public Drugs setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<DrugPresentations> getDrugPresentations() {
        return drugPresentations;
    }

    public Drugs setDrugPresentations(Collection<DrugPresentations> drugPresentations) {
        this.drugPresentations = drugPresentations;
        return this;
    }
}
