package lt.vu.persistence;

import lt.vu.entities.Equipment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class EquipmentDAO {

    @Inject
    private EntityManager em;

    public void persist(Equipment equipment){
        this.em.persist(equipment);
    }
}
