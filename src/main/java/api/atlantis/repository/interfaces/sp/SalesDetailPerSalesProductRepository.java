package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.SalesDetailPerSalesProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesDetailPerSalesProductRepository {
    List<SalesDetailPerSalesProduct> getSalesDetails(Long provkId, int year, int month, int version, Long plantId);
}
