package lt.vu.mif.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name="Team.findAll", query = "select a from Team as a")
})
@Table(name="TEAM")
public class Team implements Serializable {

    public Team(){

    }
    public Team(String teamName){
        this.teamName = teamName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;

    @Column(name="TEAM_NAME")
    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<TeamMember> teamMembers;

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!= o.getClass()) return false;
        Team team = (Team)o;
        return Objects.equals(teamName, team.teamName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(teamName);
    }

    public String getTeamName(){
        return teamName;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public List<TeamMember> getTeamMembers(){
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers){
        this.teamMembers = teamMembers;
    }

    public Integer getTeamId(){
        return teamId;
    }
    public void setTeamId(Integer teamId){
        this.teamId = teamId;
    }
}
