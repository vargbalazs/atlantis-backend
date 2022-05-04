package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.ActualCapacityPerCapGroup;
import api.atlantis.repository.interfaces.sp.ActualCapacityPerCapGroupRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ActualCapacityPerCapGroupImpl implements ActualCapacityPerCapGroupRepository {
    private final EntityManager em;

    public ActualCapacityPerCapGroupImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ActualCapacityPerCapGroup> getActualCapacities(Long companyId, Long plantId, int year) {
        Session session = em.unwrap(Session.class);
        NativeQuery<ActualCapacityPerCapGroup> query = session.createNativeQuery(
                "SELECT * FROM get_actual_capacities(:companyId, :plantId, :year)", "ActualCapacityPerCapGroupMapping");
        query.setParameter("companyId", companyId);
        query.setParameter("plantId", plantId);
        query.setParameter("year", year);

        return query.getResultList();

    }
}
