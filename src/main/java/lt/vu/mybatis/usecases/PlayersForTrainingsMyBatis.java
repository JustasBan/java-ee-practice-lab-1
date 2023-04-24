package lt.vu.mybatis.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.PlayerMapper;
import lt.vu.mybatis.model.Player;
import lt.vu.mybatis.model.Training;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model
@RequestScoped
public class PlayersForTrainingsMyBatis {

    @Inject
    private PlayerMapper playerMapper;

    @Getter
    @Setter
    private int selectedPlayerId;

    @Getter
    private List<SelectItem> options;

    @Getter
    private List<Player> playersAll;

    private void loadAllPlayers(){
        System.out.println("loadAllPlayers() called");
        try {
            this.playersAll = playerMapper.selectAll();
            System.out.println("Players loaded: " + playersAll.size());
        } catch (Exception e) {
            System.out.println("Exception while loading players: " + e.getMessage());
        }
    }

    public void handleSubmit(Training training) {
        Map<String, Object> params = new HashMap<>();
        params.put("trainingId", training.getId());
        params.put("playerId", selectedPlayerId);

        playerMapper.addPlayerToTraining(params);
    }

    @PostConstruct
    public void init() {
        options = new ArrayList<>();
        loadAllPlayers();
        for (Player player : playersAll) {
            String label = player.getName() + " " + player.getTeam().getName();
            this.options.add(new SelectItem(player.getId(), label));
        }
    }
}
