package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView(UserView.User.class)
    private long id;

    @JsonView(UserView.User.class)
    private String nom;

    @JsonView(UserView.User.class)
    private String login;

    @JsonView(UserView.User.class)
    private int numeroVoie;

    @JsonView(UserView.User.class)
    private String typeVoie;

    @JsonView(UserView.User.class)
    private String nomVoie;

    @JsonView(UserView.User.class)
    private String codePostal;

    @JsonView(UserView.User.class)
    private String ville;

    @OneToMany(mappedBy="user")
    private Collection<Reports> reports;

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.User.class)
    private Collection<LPY.appliVisiteur.Model.Entity.workedTimes> workedTimes;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public User setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public int getNumeroVoie() {
        return numeroVoie;
    }

    public User setNumeroVoie(int numeroVoie) {
        this.numeroVoie = numeroVoie;
        return this;
    }

    public String getTypeVoie() {
        return typeVoie;
    }

    public User setTypeVoie(String typeVoie) {
        this.typeVoie = typeVoie;
        return this;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public User setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
        return this;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public User setCodePostal(String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public String getVille() {
        return ville;
    }

    public User setVille(String ville) {
        this.ville = ville;
        return this;
    }

    public Collection<Reports> getReports() {
        return reports;
    }

    public User setReports(Collection<Reports> reports) {
        this.reports = reports;
        return this;
    }

    public Collection<LPY.appliVisiteur.Model.Entity.workedTimes> getWorkedTimes() {
        return workedTimes;
    }

    public User setWorkedTimes(Collection<LPY.appliVisiteur.Model.Entity.workedTimes> workedTimes) {
        this.workedTimes = workedTimes;
        return this;
    }
}
