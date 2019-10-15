package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.WorkingTimeView;
import LPY.appliVisiteur.Model.View.Visiteur.RegionView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Regions {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({WorkingTimeView.WorkingTime.class, UserView.User.class, RegionView.Region.class})
    private long id;

    @OneToMany
    private Collection<LPY.appliVisiteur.Model.Entity.workedTimes> workedTimes;

    @ManyToOne
    @JsonView(UserView.User.class)
    private Sectors sectors;

    public long getId() {
        return id;
    }

    public Regions setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<LPY.appliVisiteur.Model.Entity.workedTimes> getWorkedTimes() {
        return workedTimes;
    }

    public Regions setWorkedTimes(Collection<LPY.appliVisiteur.Model.Entity.workedTimes> workedTimes) {
        this.workedTimes = workedTimes;
        return this;
    }

    public Sectors getSectors() {
        return sectors;
    }

    public Regions setSectors(Sectors sectors) {
        this.sectors = sectors;
        return this;
    }
}
