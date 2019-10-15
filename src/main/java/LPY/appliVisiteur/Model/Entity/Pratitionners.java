package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.PraticienView;
import LPY.appliVisiteur.Model.View.Visiteur.VisitReportView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Pratitionners {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({VisitReportView.VisitReport.class, PraticienView.Praticien.class})
    private long id;

    @OneToMany
    private Collection<Reports> reports;

    @OneToMany
    @JsonView(PraticienView.Praticien.class)
    private Collection<Diplomas> diplomas;

    public long getId() {
        return id;
    }

    public Pratitionners setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<Reports> getReports() {
        return reports;
    }

    public Pratitionners setReports(Collection<Reports> reports) {
        this.reports = reports;
        return this;
    }

    public Collection<Diplomas> getDiplomas() {
        return diplomas;
    }

    public Pratitionners setDiplomas(Collection<Diplomas> diplomas) {
        this.diplomas = diplomas;
        return this;
    }
}
