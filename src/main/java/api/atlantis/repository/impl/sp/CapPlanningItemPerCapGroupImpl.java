package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;
import api.atlantis.repository.interfaces.sp.CapPlanningItemPerCapGroupRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CapPlanningItemPerCapGroupImpl implements CapPlanningItemPerCapGroupRepository {
    private final EntityManager em;

    public CapPlanningItemPerCapGroupImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CapPlanningItemPerCapGroup> getCapPlanningItems(Long companyId, Long plantId, int year, Long costAccTypeId) {
        Session session = em.unwrap(Session.class);
        NativeQuery<CapPlanningItemPerCapGroup> query = session.createNativeQuery(
                "SELECT * FROM get_cap_planning_items(:year, :companyId, :plantId, :costAccTypeId)", "CapPlanningItemPerCapGroupMapping");
        query.setParameter("year", year);
        query.setParameter("companyId", companyId);
        query.setParameter("plantId", plantId);
        query.setParameter("costAccTypeId", costAccTypeId);

        return query.getResultList();
    }
}
