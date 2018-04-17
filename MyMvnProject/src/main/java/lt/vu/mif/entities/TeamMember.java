package lt.vu.mif.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name= "TEAM_MEMBER")
public class TeamMember {

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Id
    @Size(min=11, max=11)
    @Column(name="PERSONAL_ID")
    private String personalId;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!= o.getClass()) return false;
        TeamMember teamMember = (TeamMember)o;
        return Objects.equals(personalId, teamMember.personalId);
    }

    public String getTeamMembersFirstName(){
        return firstName;
    }

    public String getTeamMembersLastName(){
        return lastName;
    }

    public void setTeamMembersFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setTeamMembersLastName(String lastName){
        this.firstName = lastName;
    }

    public String getTeamMembersPersonalId(){
        return personalId;
    }

    public void setTeamMembersPersonalId(String personalID){
        this.personalId = personalID;
    }

    public Team getTeam(){
        return team;
    }

    public void setTeam(Team team){
        this.team = team;
    }
}
