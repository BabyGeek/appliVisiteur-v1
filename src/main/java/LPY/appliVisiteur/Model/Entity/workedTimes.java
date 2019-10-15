package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.WorkingTimeView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class workedTimes {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({WorkingTimeView.WorkingTime.class, UserView.User.class})
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    @JsonView({WorkingTimeView.WorkingTime.class, UserView.User.class})
    private Departments departments;

    @ManyToOne
    @JsonView({WorkingTimeView.WorkingTime.class, UserView.User.class})
    private Regions regions;

    public long getId() {
        return id;
    }

    public workedTimes setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public workedTimes setUser(User user) {
        this.user = user;
        return this;
    }

    public Departments getDepartments() {
        return departments;
    }

    public workedTimes setDepartments(Departments departments) {
        this.departments = departments;
        return this;
    }

    public Regions getRegions() {
        return regions;
    }

    public workedTimes setRegions(Regions regions) {
        this.regions = regions;
        return this;
    }
}

