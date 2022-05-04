package api.atlantis.service.impl.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcSalesProduct;
import api.atlantis.domain.app.masterdata.production.SalesProduct;
import api.atlantis.repository.interfaces.app.forecast.frc.FrcSalesProductRepository;
import api.atlantis.service.interfaces.app.forecast.frc.FrcSalesProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrcSalesProductServiceImpl implements FrcSalesProductService {
    private FrcSalesProductRepository frcSalesProductRepository;

    public FrcSalesProductServiceImpl(FrcSalesProductRepository frcSalesProductRepository) {
        this.frcSalesProductRepository = frcSalesProductRepository;
    }

    @Override
    public Long addNew(FrcSalesProduct entity) {
        return null;
    }

    @Override
    public Long update(FrcSalesProduct entity) {
        frcSalesProductRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<FrcSalesProduct> getAll() {
        return null;
    }
}
