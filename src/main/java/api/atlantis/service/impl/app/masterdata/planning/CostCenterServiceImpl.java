package api.atlantis.service.impl.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostCenter;
import api.atlantis.repository.interfaces.app.masterdata.planning.CostCenterRepository;
import api.atlantis.service.interfaces.app.masterdata.planning.CostCenterService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostCenterServiceImpl implements CostCenterService {
    private CostCenterRepository costCenterRepository;

    public CostCenterServiceImpl(CostCenterRepository costCenterRepository) {
        this.costCenterRepository = costCenterRepository;
    }

    @Override
    public Long addNew(CostCenter entity) {
        costCenterRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CostCenter entity) {
        CostCenter updatedCostCenter = costCenterRepository.getById(entity.getId());
        updatedCostCenter.setCode(entity.getCode());
        updatedCostCenter.setCompany(entity.getCompany());
        updatedCostCenter.setName(entity.getName());
        updatedCostCenter.setPlant(entity.getPlant());
        updatedCostCenter.setPlantArea(entity.getPlantArea());
        updatedCostCenter.setYear(entity.getYear());
        costCenterRepository.save(updatedCostCenter);
        return updatedCostCenter.getId();
    }

    @Override
    public Long delete(Long id) {
        costCenterRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CostCenter> getAll() {
        return costCenterRepository.findAll();
    }

    @Override
    public List<CostCenter> getCostCenters(Long plantId, int year) {
        return costCenterRepository.findByPlantIdAndYear(plantId, year);
    }
}
