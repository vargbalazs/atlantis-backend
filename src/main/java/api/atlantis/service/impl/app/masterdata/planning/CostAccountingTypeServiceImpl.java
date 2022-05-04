package api.atlantis.service.impl.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccountingType;
import api.atlantis.repository.interfaces.app.masterdata.planning.CostAccountingTypeRepository;
import api.atlantis.service.interfaces.app.masterdata.planning.CostAccountingTypeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostAccountingTypeServiceImpl implements CostAccountingTypeService {
    private CostAccountingTypeRepository costAccountingTypeRepository;

    public CostAccountingTypeServiceImpl(CostAccountingTypeRepository costAccountingTypeRepository) {
        this.costAccountingTypeRepository = costAccountingTypeRepository;
    }

    @Override
    public Long addNew(CostAccountingType entity) {
        costAccountingTypeRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CostAccountingType entity) {
        CostAccountingType updatedCostAccType = costAccountingTypeRepository.getById(entity.getId());
        updatedCostAccType.setName(entity.getName());
        updatedCostAccType.setDescr(entity.getDescr());
        costAccountingTypeRepository.save(updatedCostAccType);
        return updatedCostAccType.getId();
    }

    @Override
    public Long delete(Long id) {
        costAccountingTypeRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CostAccountingType> getAll() {
        return costAccountingTypeRepository.findAll();
    }
}
