package lt.vu.mif.usecases;

import lt.vu.mif.entities.Team;
import lt.vu.mif.persistence.TeamsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class Teams {
    @Inject
    private TeamsDAO teamsDAO;

    private List<Team> allTeams;
    private Team newTeam = new Team();

    @PostConstruct
    public void init(){
        this.loadTeams();
    }

    @Transactional
    public String createNewTeam(){
        teamsDAO.save(newTeam);
        return "index?faces-redirect=true";
    }


    private void loadTeams(){
        this.allTeams = teamsDAO.loadAll();
    }

    public List<Team> getAllTeams(){
        return allTeams;
    }

    public Team getNewTeam(){
        return newTeam;
    }

    public void setNewTeam(Team newTeam){
        this.newTeam = newTeam;
    }
}
