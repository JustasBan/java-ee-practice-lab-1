package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.INameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateTrainingName implements Serializable {

    @Inject
    INameGenerator nameGenerator;

    private CompletableFuture<String> nameGeneratorTask = null;

    @LoggedInvocation
    public String generateRandomName(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        nameGeneratorTask = CompletableFuture.supplyAsync(() -> nameGenerator.generateName());

        return "/trainingDetails.xhtml?faces-redirect=true&trainingId=" + requestParameters.get("trainingId");
    }

    public boolean isNameGenerationRunning(){
        return  nameGeneratorTask != null && !nameGeneratorTask.isDone();
    }

    public String getNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (nameGeneratorTask == null) {
            return null;
        } else if (isNameGenerationRunning()) {
            return "Name generation in progress...";
        }
        return nameGeneratorTask.get();
    }
}
