package api.atlantis.service.impl.app.planning;

import api.atlantis.domain.app.planning.CostPlanningItem;
import api.atlantis.repository.interfaces.app.planning.CostPlanningItemRepository;
import api.atlantis.service.interfaces.app.planning.CostPlanningItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostPlanningItemServiceImpl implements CostPlanningItemService {
    private CostPlanningItemRepository costPlanningItemRepository;

    public CostPlanningItemServiceImpl(CostPlanningItemRepository costPlanningItemRepository) {
        this.costPlanningItemRepository = costPlanningItemRepository;
    }

    @Override
    public Long addNew(CostPlanningItem entity) {
        costPlanningItemRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CostPlanningItem entity) {
        CostPlanningItem updatedCostPlanningItem = costPlanningItemRepository.getById(entity.getId());
        updatedCostPlanningItem.setAmount(entity.getAmount());
        updatedCostPlanningItem.setCostAccount(entity.getCostAccount());
        updatedCostPlanningItem.setCostCenter(entity.getCostCenter());
        updatedCostPlanningItem.setCostGroup(entity.getCostGroup());
        updatedCostPlanningItem.setComment(entity.getComment());
        updatedCostPlanningItem.setItemName(entity.getItemName());
        updatedCostPlanningItem.setAmountInCurrency(entity.getAmountInCurrency());
        updatedCostPlanningItem.setCostAccount(entity.getCostAccount());
        updatedCostPlanningItem.setCurrency(entity.getCurrency());
        updatedCostPlanningItem.setDistribution(entity.getDistribution());
        updatedCostPlanningItem.setP1(entity.getP1());
        updatedCostPlanningItem.setP2(entity.getP2());
        updatedCostPlanningItem.setP3(entity.getP3());
        updatedCostPlanningItem.setP4(entity.getP4());
        updatedCostPlanningItem.setP5(entity.getP5());
        updatedCostPlanningItem.setP6(entity.getP6());
        updatedCostPlanningItem.setP7(entity.getP7());
        updatedCostPlanningItem.setP8(entity.getP8());
        updatedCostPlanningItem.setP9(entity.getP9());
        updatedCostPlanningItem.setP10(entity.getP10());
        updatedCostPlanningItem.setP11(entity.getP11());
        updatedCostPlanningItem.setP12(entity.getP12());
        return null;
    }

    @Override
    public Long delete(Long id) {
        costPlanningItemRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CostPlanningItem> getAll() {
        return null;
    }

    @Override
    public List<CostPlanningItem> getPlanningItems(Long costCenterId, Long costAccTypeId) {
        return costPlanningItemRepository.findByCostCenterIdAndCostAccTypeId(costCenterId, costAccTypeId);
    }
}
