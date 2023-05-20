package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Training.findAll", query = "select tr from Training as tr"),
        @NamedQuery(name = "Training.findAllPlayers", query = "SELECT t.players FROM Training t WHERE t.id = :trainingId")
})
@Table(name = "TRAINING")
@EqualsAndHashCode(of={"name"})
@Getter @Setter
public class Training {

    public Training(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "train_name", nullable=false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name="PLAYER_TRAINING",
            joinColumns=@JoinColumn(name="TRAINING_ID"),
            inverseJoinColumns=@JoinColumn(name="PLAYER_ID"))
    @Getter @Setter
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "training")
    private List<Equipment> equipments = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;
}
