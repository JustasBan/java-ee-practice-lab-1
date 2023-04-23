package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EQUIPMENT")
@EqualsAndHashCode(of={"name"})
@Getter @Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name="TRAINING_ID")
    private Training training;

    public Equipment() {
    }
}
