package lt.vu.mif.persistence;

import lt.vu.mif.entities.TeamMember;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

//Application scoped beans are created once but uses memory space.
// Request scoped beans are created for each call but using memory space only at lifetime.
// Request scoped beans could created multiple times.
//@SessionScoped is tied to the current HTTP session;
@ApplicationScoped
public class TeamMembersDAO {
    @Inject //@Inject is part of a new Java technology called CDI that defines a standard for dependency injection
    private EntityManager em;

    public void save(TeamMember teamMember){
        this.em.persist(teamMember);
    }
}
