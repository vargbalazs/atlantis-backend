package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.FrcSalesProductPerCapGroup;
import api.atlantis.repository.interfaces.sp.FrcSalesProductPerCapGroupRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class FrcSalesProductPerCapGroupImpl implements FrcSalesProductPerCapGroupRepository {
    private final EntityManager em;

    public FrcSalesProductPerCapGroupImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<FrcSalesProductPerCapGroup> getFrcSalesProducts(Long frcId, int year, Long plantId) {
        Session session = em.unwrap(Session.class);
        NativeQuery<FrcSalesProductPerCapGroup> query = session.createNativeQuery(
                "SELECT * FROM get_frc_salesproduct(:frcId, :year, :plantId)", "FrcSalesProductPerCapGroupMapping");
        query.setParameter("frcId", frcId);
        query.setParameter("year", year);
        query.setParameter("plantId", plantId);

        return query.getResultList();
    }
}
