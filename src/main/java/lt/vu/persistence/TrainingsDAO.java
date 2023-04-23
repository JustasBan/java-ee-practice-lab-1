package lt.vu.persistence;

import lt.vu.entities.Player;
import lt.vu.entities.Team;
import lt.vu.entities.Training;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TrainingsDAO {
    @Inject
    private EntityManager em;

    public List<Training> loadAll() {
        return em.createNamedQuery("Training.findAll", Training.class).getResultList();
    }

    public void persist(Training t){
        this.em.persist(t);
    }

    @Transactional
    public void addPlayerToTraining(Integer playerId, Integer trainingId) {
        Player player = em.find(Player.class, playerId);
        Training training = em.find(Training.class, trainingId);

        if (player != null && training != null) {
            training.getPlayers().add(player);
            em.persist(training);
        }
    }

    public List<Player> getPlayersByTrainingId(int trainingId) {
        Training training = em.find(Training.class, trainingId);
        if (training != null) {
            return training.getPlayers();
        }
        return new ArrayList<>();
    }
}
