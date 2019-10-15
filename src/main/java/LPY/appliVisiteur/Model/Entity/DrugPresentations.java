package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DrugPresentationView;
import LPY.appliVisiteur.Model.View.Visiteur.VisitReportView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class DrugPresentations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonView({VisitReportView.VisitReport.class, DrugPresentationView.DrugPresentation.class})
    private long id;

    @ManyToOne
    @JsonView({VisitReportView.VisitReport.class, DrugPresentationView.DrugPresentation.class})
    private Drugs drugs;

    @ManyToOne
    @JsonView(DrugPresentationView.DrugPresentation.class)
    private Reports Reports;

    public Drugs getDrugs() {
        return drugs;
    }

    public DrugPresentations setDrugs(Drugs drugs) {
        this.drugs = drugs;
        return this;
    }

    public Reports getReports() {
        return Reports;
    }

    public DrugPresentations setReports(Reports reports) {
        this.Reports = reports;
        return this;
    }
}
