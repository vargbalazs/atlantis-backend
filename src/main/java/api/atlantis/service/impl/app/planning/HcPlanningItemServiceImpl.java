package api.atlantis.service.impl.app.planning;

import api.atlantis.domain.app.planning.HcPlanningItem;
import api.atlantis.repository.interfaces.app.planning.HcPlanningItemRepository;
import api.atlantis.service.interfaces.app.planning.HcPlanningItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HcPlanningItemServiceImpl implements HcPlanningItemService {
    private HcPlanningItemRepository hcPlanningItemRepository;

    public HcPlanningItemServiceImpl(HcPlanningItemRepository hcPlanningItemRepository) {
        this.hcPlanningItemRepository = hcPlanningItemRepository;
    }

    @Override
    public Long addNew(HcPlanningItem entity) {
        hcPlanningItemRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(HcPlanningItem entity) {
        HcPlanningItem updatedHcPlanningItem = hcPlanningItemRepository.getById(entity.getId());
        updatedHcPlanningItem.setComment(entity.getComment());
        updatedHcPlanningItem.setCostCenter(entity.getCostCenter());
        updatedHcPlanningItem.setCostGroup(entity.getCostGroup());
        updatedHcPlanningItem.setCompany(entity.getCompany());
        updatedHcPlanningItem.setCostAccType(entity.getCostAccType());
        updatedHcPlanningItem.setCostAssigned(entity.isCostAssigned());
        updatedHcPlanningItem.setJob(entity.getJob());
        updatedHcPlanningItem.setPlant(entity.getPlant());
        updatedHcPlanningItem.setP1(entity.getP1());
        updatedHcPlanningItem.setP2(entity.getP2());
        updatedHcPlanningItem.setP3(entity.getP3());
        updatedHcPlanningItem.setP4(entity.getP4());
        updatedHcPlanningItem.setP5(entity.getP5());
        updatedHcPlanningItem.setP6(entity.getP6());
        updatedHcPlanningItem.setP7(entity.getP7());
        updatedHcPlanningItem.setP8(entity.getP8());
        updatedHcPlanningItem.setP9(entity.getP9());
        updatedHcPlanningItem.setP10(entity.getP10());
        updatedHcPlanningItem.setP11(entity.getP11());
        updatedHcPlanningItem.setP12(entity.getP12());
        hcPlanningItemRepository.save(updatedHcPlanningItem);
        return updatedHcPlanningItem.getId();
    }

    @Override
    public Long delete(Long id) {
        hcPlanningItemRepository.deleteById(id);
        return id;
    }

    @Override
    public List<HcPlanningItem> getAll() {
        return null;
    }

    @Override
    public List<HcPlanningItem> getPlanningItems(Long costCenterId, Long costAccTypeId) {
        return hcPlanningItemRepository.findByCostCenterIdAndCostAccTypeId(costCenterId, costAccTypeId);
    }
}
