package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DepartmentView;
import LPY.appliVisiteur.Model.View.Visiteur.WorkingTimeView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({WorkingTimeView.WorkingTime.class, UserView.User.class, DepartmentView.Department.class})
    private long id;

    @OneToMany(mappedBy = "departement")
    private Collection<workedTimes> workingTime;

    public long getId() {
        return id;
    }

    public Departments setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<workedTimes> getWorkingTime() {
        return workingTime;
    }

    public Departments setWorkingTime(Collection<workedTimes> workingTime) {
        this.workingTime = workingTime;
        return this;
    }
}
