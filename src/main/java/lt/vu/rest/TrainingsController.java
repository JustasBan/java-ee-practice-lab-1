package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Training;
import lt.vu.persistence.TrainingsDAO;
import lt.vu.rest.contracts.TrainingDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/trainings")
public class TrainingsController {

    @Inject
    @Setter @Getter
    private TrainingsDAO trainingsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Training training = trainingsDAO.findOne(id);
        if (training == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setName(training.getName());

        return Response.ok(trainingDto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(TrainingDto trainingData) {
        Training newTraining = new Training();
        newTraining.setName(trainingData.getName());
        trainingsDAO.persist(newTraining);
        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer trainingId,
            TrainingDto trainingData) {
        try {
            Training existingTraining = trainingsDAO.findOne(trainingId);
            if (existingTraining == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingTraining.setName(trainingData.getName());
            trainingsDAO.update(existingTraining);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
