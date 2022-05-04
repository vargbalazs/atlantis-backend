package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.ProvkDetailPerCapGroup;
import api.atlantis.repository.interfaces.sp.ProvkDetailPerCapGroupRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ProvkDetailPerCapGroupImpl implements ProvkDetailPerCapGroupRepository {
    private final EntityManager em;

    public ProvkDetailPerCapGroupImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ProvkDetailPerCapGroup> getProvkDetails(Long provkId, int year, int month, int version, Long capTypeId,
                                                        Long plantId) {
        Session session = em.unwrap(Session.class);
        NativeQuery<ProvkDetailPerCapGroup> query = session.createNativeQuery(
                "SELECT * FROM get_provk_details(:provkId, :year, :month, :version, :plantId, :capTypeId)", "ProvkDetailPerCapGroupMapping");
        query.setParameter("provkId", provkId);
        query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("version", version);
        query.setParameter("plantId", plantId);
        query.setParameter("capTypeId", capTypeId);

        return query.getResultList();
    }
}
