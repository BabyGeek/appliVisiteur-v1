package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.VisitReportView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Reports {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView(VisitReportView.VisitReport.class)
    private long id;

    @JsonView(VisitReportView.VisitReport.class)
    private String note;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "report")
    @JsonView(VisitReportView.VisitReport.class)
    private Collection<DrugPresentations> drugPresentations;

    @ManyToOne
    @JsonView(VisitReportView.VisitReport.class)
    private Pratitionners pratitionners;

    public String getNote() {
        return note;
    }

    public Reports setNote(String note) {
        this.note = note;
        return this;
    }

    public Reports()
    {
        drugPresentations = new ArrayList<DrugPresentations>();
    }
    public long getId() {
        return id;
    }

    public Reports setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Reports setUser(User user) {
        this.user = user;
        return this;
    }

    public Collection<DrugPresentations> getDrugPresentations() {
        return drugPresentations;
    }

    public Reports setDrugPresentations(Collection<DrugPresentations> drugPresentations) {
        this.drugPresentations = drugPresentations;
        return this;
    }

    public Pratitionners getPratitionners() {
        return pratitionners;
    }

    public Reports setPratitionners(Pratitionners pratitionners) {
        this.pratitionners = pratitionners;
        return this;
    }
}
