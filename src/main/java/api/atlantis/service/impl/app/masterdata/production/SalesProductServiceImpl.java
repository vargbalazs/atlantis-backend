package api.atlantis.service.impl.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.SalesProduct;
import api.atlantis.repository.interfaces.app.masterdata.production.SalesProductRepository;
import api.atlantis.service.interfaces.app.masterdata.production.SalesProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SalesProductServiceImpl implements SalesProductService {
    private SalesProductRepository salesProductRepository;

    public SalesProductServiceImpl(SalesProductRepository salesProductRepository) {
        this.salesProductRepository = salesProductRepository;
    }

    @Override
    public Long addNew(SalesProduct entity) {
        salesProductRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(SalesProduct entity) {
        SalesProduct updatedSalesProduct = salesProductRepository.getById(entity.getId());
        updatedSalesProduct.setCapGroup(entity.getCapGroup());
        updatedSalesProduct.setCompany(entity.getCompany());
        updatedSalesProduct.setName(entity.getName());
        updatedSalesProduct.setPlant(entity.getPlant());
        updatedSalesProduct.setUnit(entity.getUnit());
        updatedSalesProduct.setYear(entity.getYear());
        salesProductRepository.save(updatedSalesProduct);
        return updatedSalesProduct.getId();
    }

    @Override
    public Long delete(Long id) {
        salesProductRepository.deleteById(id);
        return id;
    }

    @Override
    public List<SalesProduct> getAll() {
        return salesProductRepository.findAll();
    }
}
