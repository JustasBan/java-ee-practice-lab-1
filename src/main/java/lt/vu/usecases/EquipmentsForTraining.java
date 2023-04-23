package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Equipment;
import lt.vu.entities.Player;
import lt.vu.entities.Training;
import lt.vu.persistence.EquipmentDAO;
import lt.vu.persistence.TrainingsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class EquipmentsForTraining implements Serializable {

    @Inject
    EquipmentDAO equipmentDAO;

    @Inject
    TrainingsDAO trainingsDAO;

    @Getter @Setter
    private List<Training> trainings;

    @Getter @Setter
    private Equipment equipmentToCreate = new Equipment();

    @PostConstruct
    public void init() {
        this.trainings = trainingsDAO.loadAll();
    }

    @Transactional
    public void createEquipment(Training trainingToAdd){
        equipmentToCreate.setTraining(trainingToAdd);
        equipmentDAO.persist(equipmentToCreate);
    }
}
