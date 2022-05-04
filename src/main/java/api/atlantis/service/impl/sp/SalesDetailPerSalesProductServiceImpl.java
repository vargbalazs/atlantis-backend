package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.SalesDetailPerSalesProduct;
import api.atlantis.repository.impl.sp.SalesDetailPerSalesProductImpl;
import api.atlantis.service.interfaces.sp.SalesDetailPerSalesProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SalesDetailPerSalesProductServiceImpl implements SalesDetailPerSalesProductService {
    private SalesDetailPerSalesProductImpl rep;

    public SalesDetailPerSalesProductServiceImpl(SalesDetailPerSalesProductImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<SalesDetailPerSalesProduct> getSalesDetails(Long provkId, int year, int month, int version, Long plantId) {
        return rep.getSalesDetails(provkId, year, month, version, plantId);
    }
}
