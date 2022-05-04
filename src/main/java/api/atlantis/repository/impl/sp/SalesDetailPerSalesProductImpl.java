package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.SalesDetailPerSalesProduct;
import api.atlantis.repository.interfaces.sp.SalesDetailPerSalesProductRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class SalesDetailPerSalesProductImpl implements SalesDetailPerSalesProductRepository {
    private final EntityManager em;

    public SalesDetailPerSalesProductImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<SalesDetailPerSalesProduct> getSalesDetails(Long provkId, int year, int month, int version, Long plantId) {
        Session session = em.unwrap(Session.class);
        NativeQuery<SalesDetailPerSalesProduct> query = session.createNativeQuery(
                "SELECT * FROM get_provk_sales_details(:provkId, :year, :month, :version, :plantId)", "SalesDetailPerSalesProductMapping");
        query.setParameter("provkId", provkId);
        query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("version", version);
        query.setParameter("plantId", plantId);

        return query.getResultList();
    }
}
