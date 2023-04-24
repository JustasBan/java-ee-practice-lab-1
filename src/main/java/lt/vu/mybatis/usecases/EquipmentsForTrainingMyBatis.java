package lt.vu.mybatis.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.TrainingMapper;
import lt.vu.mybatis.model.Training;
import lt.vu.mybatis.model.Equipment;
import lt.vu.mybatis.dao.EquipmentMapper;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class EquipmentsForTrainingMyBatis {

    @Inject
    EquipmentMapper equipmentMapper;

    @Inject
    TrainingMapper trainingMapper;

    @Getter
    @Setter
    private Equipment equipmentToCreate = new Equipment();

    @Transactional
    public void createEquipment(Training trainingToAdd){
        equipmentToCreate.setTrainingId(trainingToAdd.getId());
        equipmentMapper.insert(equipmentToCreate);
    }
}
