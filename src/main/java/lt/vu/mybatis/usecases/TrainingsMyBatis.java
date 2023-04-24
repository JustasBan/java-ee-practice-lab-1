package lt.vu.mybatis.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.model.Training;
import lt.vu.mybatis.dao.TrainingMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class TrainingsMyBatis {

    @Inject
    private TrainingMapper trainingMapper;

    @Getter
    @Setter
    private Training trainingToCreate = new Training();

    @Transactional
    public void createTraining(){
        this.trainingMapper.insert(trainingToCreate);
    }

    @Getter
    private List<Training> allTrainings;

    @PostConstruct
    public void init(){
        loadAllTrainings();
    }

    private void loadAllTrainings(){
        this.allTrainings = trainingMapper.selectAll();
    }
}
