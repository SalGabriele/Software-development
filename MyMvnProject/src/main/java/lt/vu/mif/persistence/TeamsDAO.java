package lt.vu.mif.persistence;

import lt.vu.mif.entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TeamsDAO {
    @Inject
    private EntityManager em;

    public List<Team> loadAll(){
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }

    public Team findOne(Integer teamId){
        return em.find(Team.class, teamId);
    }

    public void save(Team team){
        this.em.persist(team);
    }
}
