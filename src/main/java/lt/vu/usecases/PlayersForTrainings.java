package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Player;
import lt.vu.persistence.PlayersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PlayersForTrainings {

    @Inject
    Trainings trainings;

    @Getter @Setter
    private int selectedPlayerId;

    public void handleSubmit(Integer trainingId) {
        trainings.addPlayerToTraining(selectedPlayerId, trainingId);
    }

    @Inject
    private PlayersDAO playerDAO;

    @Getter
    private List<SelectItem> options;

    @PostConstruct
    public void init() {
        this.options = new ArrayList<>();
        List<Player> players = playerDAO.getAllPlayers();
        for (Player player : players) {
            String label = player.getName() + " - " + player.getTeam().getName();
            this.options.add(new SelectItem(player.getId(), label));
        }
    }
}
