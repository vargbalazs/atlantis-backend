package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.SalesDetailPerSalesProduct;

import java.util.List;

public interface SalesDetailPerSalesProductService {
    List<SalesDetailPerSalesProduct> getSalesDetails(Long provkId, int year, int month, int version, Long plantId);
}
