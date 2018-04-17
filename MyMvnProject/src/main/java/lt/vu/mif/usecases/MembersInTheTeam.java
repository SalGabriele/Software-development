package lt.vu.mif.usecases;

import lt.vu.mif.entities.Team;
import lt.vu.mif.entities.TeamMember;
import lt.vu.mif.persistence.TeamMembersDAO;
import lt.vu.mif.persistence.TeamsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class MembersInTheTeam {
    private Team team;

    private TeamMember newTeamMember = new TeamMember();

    @Inject
    private TeamsDAO teamsDAO;

    @Inject
    private TeamMembersDAO teamMembersDAO;

    @PostConstruct
    public void init(){

        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer teamId = Integer.parseInt(requestParameters.get("teamId"));
        this.team = teamsDAO.findOne(teamId);
    }

    @Transactional
    public String addTeamMember(){
        newTeamMember.setTeam(this.team);
        teamMembersDAO.save(newTeamMember);
        return "/teamMembers?faces-redirect=true&teamId=" + this.team.getTeamId();
    }

    public Team getTeam(){
        return team;
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public TeamMember getNewTeamMember(){
        return newTeamMember;
    }

    public void setNewTeamMember(TeamMember newTeamMember){
        this.newTeamMember = newTeamMember;
    }
}
