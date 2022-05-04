package api.atlantis.service.impl.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostGroup;
import api.atlantis.repository.interfaces.app.masterdata.planning.CostGroupRepository;
import api.atlantis.service.interfaces.app.masterdata.planning.CostGroupService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostGroupServiceImpl implements CostGroupService {
    private CostGroupRepository costGroupRepository;

    public CostGroupServiceImpl(CostGroupRepository costGroupRepository) {
        this.costGroupRepository = costGroupRepository;
    }

    @Override
    public Long addNew(CostGroup entity) {
        costGroupRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CostGroup entity) {
        CostGroup updatedCostGroup = costGroupRepository.getById(entity.getId());
        updatedCostGroup.setName(entity.getName());
        updatedCostGroup.setRowIndex(entity.getRowIndex());
        updatedCostGroup.setDirectWagesCost(entity.isDirectWagesCost());
        updatedCostGroup.setOhterPlantCost(entity.isOhterPlantCost());
        updatedCostGroup.setUsedForPersPlanning(entity.isUsedForPersPlanning());
        updatedCostGroup.setCompany(entity.getCompany());
        costGroupRepository.save(updatedCostGroup);
        return updatedCostGroup.getId();
    }

    @Override
    public Long delete(Long id) {
        costGroupRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CostGroup> getAll() {
        return costGroupRepository.findAll();
    }

    @Override
    public List<CostGroup> getCostGroups(Long companyId) {
        return costGroupRepository.findByCompanyId(companyId);
    }
}
