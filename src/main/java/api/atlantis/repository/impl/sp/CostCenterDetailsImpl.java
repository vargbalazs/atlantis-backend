package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.CostCenterDetails;
import api.atlantis.repository.interfaces.sp.CostCenterDetailsRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CostCenterDetailsImpl implements CostCenterDetailsRepository {
    private final EntityManager em;

    public CostCenterDetailsImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CostCenterDetails> getCostCenterDetails(int year, int month, Long costCenterId, Long costAccTypeId,
                                                        Long plantId, Long companyId) {
        Session session = em.unwrap(Session.class);
        NativeQuery<CostCenterDetails> query = session.createNativeQuery(
                "SELECT * FROM get_costcenter_details(:year, :month, :costCenterId, :costAccTypeId, :plantId, :companyId)",
                "CostCenterDetailsMapping");
        query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("costCenterId", costCenterId);
        query.setParameter("costAccTypeId", costAccTypeId);
        query.setParameter("companyId", companyId);
        query.setParameter("plantId", plantId);

        return query.getResultList();
    }
}
