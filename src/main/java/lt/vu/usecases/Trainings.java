package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Player;
import lt.vu.entities.Training;
import lt.vu.persistence.TrainingsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Trainings {

    @Inject
    private TrainingsDAO trainingsDAO;

    @Getter @Setter
    private Training trainingToCreate = new Training();

    @Getter
    private List<Training> allTrainings;

    @PostConstruct
    public void init(){
        loadAllTrainings();
    }

    @Transactional
    public void createTraining(){
        this.trainingsDAO.persist(trainingToCreate);
    }


    @Transactional
    public void addPlayerToTraining(Integer playerId, Integer trainingId) {
        this.trainingsDAO.addPlayerToTraining(playerId, trainingId);
    }

    private void loadAllTrainings(){
        this.allTrainings = trainingsDAO.loadAll();
    }

    public List<Player> getLoadPlayers(Integer trainId) {
        return trainingsDAO.getPlayersByTrainingId(trainId);
    }
}
