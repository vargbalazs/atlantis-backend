package api.atlantis.service.impl.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocation;
import api.atlantis.repository.interfaces.app.masterdata.planning.CostAllocationRepository;
import api.atlantis.service.interfaces.app.masterdata.planning.CostAllocationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostAllocationServiceImpl implements CostAllocationService {
    private CostAllocationRepository costAllocationRepository;

    public CostAllocationServiceImpl(CostAllocationRepository costAllocationRepository) {
        this.costAllocationRepository = costAllocationRepository;
    }

    @Override
    public Long addNew(CostAllocation entity) {
        costAllocationRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CostAllocation entity) {
        CostAllocation updatedCostAlloc = costAllocationRepository.getById(entity.getId());
        updatedCostAlloc.setAllocCostCenter(entity.getAllocCostCenter());
        updatedCostAlloc.setAllocCapacity(entity.isAllocCapacity());
        updatedCostAlloc.setCompany(entity.getCompany());
        updatedCostAlloc.setCostAccount(entity.getCostAccount());
        updatedCostAlloc.setCapacityUnit(entity.getCapacityUnit());
        updatedCostAlloc.setLevel(entity.getLevel());
        updatedCostAlloc.setName(entity.getName());
        updatedCostAlloc.setPlant(entity.getPlant());
        updatedCostAlloc.setTotalCapacity(entity.getTotalCapacity());
        updatedCostAlloc.setYear(entity.getYear());
        return null;
    }

    @Override
    public Long delete(Long id) {
        costAllocationRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CostAllocation> getAll() {
        return costAllocationRepository.findAll();
    }
}
