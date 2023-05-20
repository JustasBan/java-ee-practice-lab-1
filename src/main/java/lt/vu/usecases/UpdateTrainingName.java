package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Training;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.TrainingsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateTrainingName implements Serializable {
    private Training training;

    @Inject
    private TrainingsDAO trainingsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateTrainingName INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer trainingId = Integer.parseInt(requestParameters.get("trainingId"));
        this.training = trainingsDAO.findOne(trainingId);
    }

    @Transactional
    @LoggedInvocation
    public String updateName() {
        try{
            trainingsDAO.update(this.training);
        }catch (OptimisticLockException e){
            return "/trainingDetails.xhtml?faces-redirect=true&trainingId=" + this.training.getId() + "&error=optimistic-lock-exception";
        }
        return "index.xhtml?faces-redirect=true";
    }
}
