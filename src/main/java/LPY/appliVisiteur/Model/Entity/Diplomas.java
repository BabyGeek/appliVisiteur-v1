package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DepartmentView;
import LPY.appliVisiteur.Model.View.Visiteur.DiplomaView;
import LPY.appliVisiteur.Model.View.Visiteur.PraticienView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class Diplomas {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({DepartmentView.Department.class, PraticienView.Praticien.class, DiplomaView.Diploma.class})
    private long id;

    @ManyToOne
    private Pratitionners pratitionners;

    public long getId() {
        return id;
    }

    public Diplomas setId(long id) {
        this.id = id;
        return this;
    }

    public Pratitionners getPratitionners() {
        return pratitionners;
    }

    public Diplomas setPratitionners(Pratitionners pratitionners) {
        this.pratitionners = pratitionners;
        return this;
    }
}
