package api.atlantis.service.interfaces.app.planning;

import api.atlantis.domain.app.planning.CostPlanningItem;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface CostPlanningItemService extends BaseCrudService<CostPlanningItem> {
    List<CostPlanningItem> getPlanningItems(Long costCenterId, Long costAccTypeId);
}
