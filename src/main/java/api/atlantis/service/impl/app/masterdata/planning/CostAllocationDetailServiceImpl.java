package api.atlantis.service.impl.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocationDetail;
import api.atlantis.repository.interfaces.app.masterdata.planning.CostAllocationDetailRepository;
import api.atlantis.service.interfaces.app.masterdata.planning.CostAllocationDetailService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostAllocationDetailServiceImpl implements CostAllocationDetailService {
    private CostAllocationDetailRepository costAllocationDetailRepository;

    public CostAllocationDetailServiceImpl(CostAllocationDetailRepository costAllocationDetailRepository) {
        this.costAllocationDetailRepository = costAllocationDetailRepository;
    }

    @Override
    public Long addNew(CostAllocationDetail entity) {
        costAllocationDetailRepository.save(entity);
        return entity.getId();
    }

    @Override
    public void saveAll(List<CostAllocationDetail> costAllocationDetails) {
        long costAllocationId = costAllocationDetails.get(0).getCostAllocation().getId();
        List<CostAllocationDetail> originalDetails = getDetailsByAllocId(costAllocationId);
        for (CostAllocationDetail originalDetail : originalDetails) {
            if (!costAllocationDetails.stream().anyMatch(detail -> detail.getId() == originalDetail.getId())) {
                costAllocationDetailRepository.deleteById(originalDetail.getId());
            }
        }
        costAllocationDetailRepository.saveAll(costAllocationDetails);
    }

    @Override
    public Long update(CostAllocationDetail entity) {
        CostAllocationDetail updatedCostAllocDetail = costAllocationDetailRepository.getById(entity.getId());
        updatedCostAllocDetail.setCostAllocation(entity.getCostAllocation());
        updatedCostAllocDetail.setBaseCostCenter(entity.getBaseCostCenter());
        updatedCostAllocDetail.setCapacity(entity.getCapacity());
        updatedCostAllocDetail.setRecCostCenter(entity.getRecCostCenter());
        updatedCostAllocDetail.setIndex(entity.getIndex());
        updatedCostAllocDetail.setPercent(entity.getPercent());
        costAllocationDetailRepository.save(updatedCostAllocDetail);
        return updatedCostAllocDetail.getId();
    }

    @Override
    public Long delete(Long id) {
        costAllocationDetailRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CostAllocationDetail> getAll() {
        return costAllocationDetailRepository.findAll();
    }

    @Override
    public List<CostAllocationDetail> getDetailsByAllocId(Long id) {
        return costAllocationDetailRepository.findAllByCostAllocationId(id);
    }

    @Override
    public void deleteByCostAllocationId(Long id) {
        costAllocationDetailRepository.deleteAllByCostAllocationId(id);
    }

}
