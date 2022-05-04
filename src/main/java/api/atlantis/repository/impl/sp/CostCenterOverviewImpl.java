package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.CostCenterOverview;
import api.atlantis.repository.interfaces.sp.CostCenterOverviewRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CostCenterOverviewImpl implements CostCenterOverviewRepository {
    private final EntityManager em;

    public CostCenterOverviewImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CostCenterOverview> getCostCenterOverview(int year, int month, Long costAccTypeId, Long plantId) {
        Session session = em.unwrap(Session.class);
        NativeQuery<CostCenterOverview> query = session.createNativeQuery(
                "SELECT * FROM get_costcenter_overview(:year, :month, :costAccTypeId, :plantId)", "CostCenterOverviewMapping");
        query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("costAccTypeId", costAccTypeId);
        query.setParameter("plantId", plantId);

        return query.getResultList();
    }
}
