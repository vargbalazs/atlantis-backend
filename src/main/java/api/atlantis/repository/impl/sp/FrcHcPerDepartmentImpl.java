package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.FrcHcPerDepartment;
import api.atlantis.repository.interfaces.sp.FrcHcPerDepartmentRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class FrcHcPerDepartmentImpl implements FrcHcPerDepartmentRepository {
    private final EntityManager em;

    public FrcHcPerDepartmentImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<FrcHcPerDepartment> getFrcHc(Long frcId, Long departmentId, Long costAccTypeId, Long plantId, int year) {
        Session session = em.unwrap(Session.class);
        NativeQuery<FrcHcPerDepartment> query = session.createNativeQuery(
                "SELECT * FROM get_frc_hc(:frcId, :depId, :costAccTypeId, :plantId, :year)", "FrcHcPerDepartmentMapping");
        query.setParameter("frcId", frcId);
        query.setParameter("depId", departmentId);
        query.setParameter("costAccTypeId", costAccTypeId);
        query.setParameter("plantId", plantId);
        query.setParameter("year", year);

        return query.getResultList();
    }
}
