package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;
import api.atlantis.domain.sp.FrcCapacityPerCapGroup;
import api.atlantis.repository.interfaces.sp.FrcCapacityPerCapGroupRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class FrcCapacityPerCapGroupImpl implements FrcCapacityPerCapGroupRepository {
    private final EntityManager em;

    public FrcCapacityPerCapGroupImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<FrcCapacityPerCapGroup> getFrcCapacities(Long frcId, int year, Long plantId) {
        Session session = em.unwrap(Session.class);
        NativeQuery<FrcCapacityPerCapGroup> query = session.createNativeQuery(
                "SELECT * FROM get_frc_capacity(:frcId, :year, :plantId)", "FrcCapacityPerCapGroupMapping");
        query.setParameter("frcId", frcId);
        query.setParameter("year", year);
        query.setParameter("plantId", plantId);

        return query.getResultList();
    }
}
