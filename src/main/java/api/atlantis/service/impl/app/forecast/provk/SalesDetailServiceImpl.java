package api.atlantis.service.impl.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.SalesDetail;
import api.atlantis.repository.interfaces.app.forecast.provk.SalesDetailRepository;
import api.atlantis.service.interfaces.app.forecast.provk.SalesDetailService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SalesDetailServiceImpl implements SalesDetailService {
    private SalesDetailRepository salesDetailRepository;

    public SalesDetailServiceImpl(SalesDetailRepository salesDetailRepository) {
        this.salesDetailRepository = salesDetailRepository;
    }

    @Override
    public Long addNew(SalesDetail entity) {
        return null;
    }

    @Override
    public void saveAll(List<SalesDetail> salesDetails) {
        this.salesDetailRepository.saveAll(salesDetails);
    }

    @Override
    public Long update(SalesDetail entity) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<SalesDetail> getAll() {
        return null;
    }

    @Override
    public List<SalesDetail> getSalesDetails(Long provkId, int year, int month, int version) {
        return salesDetailRepository.getSalesDetails(provkId, year, month, version);
    }

}
