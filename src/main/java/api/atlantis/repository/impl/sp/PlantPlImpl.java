package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.PlantPl;
import api.atlantis.repository.interfaces.sp.PlantPlRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class PlantPlImpl implements PlantPlRepository {
    private final EntityManager em;

    public PlantPlImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<PlantPl> getPlantPl(int year, int month, Long costAccTypeId, Long plantId, Long companyId) {
        Session session = em.unwrap(Session.class);
        NativeQuery<PlantPl> query = session.createNativeQuery(
                "SELECT * FROM get_plantpl(:year, :month, :costAccTypeId, :plantId, :companyId)",
                "PlantPlMapping");
        query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("costAccTypeId", costAccTypeId);
        query.setParameter("plantId", plantId);
        query.setParameter("companyId", companyId);

        return query.getResultList();
    }
}
