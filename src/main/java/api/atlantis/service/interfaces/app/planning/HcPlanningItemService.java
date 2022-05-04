package api.atlantis.service.interfaces.app.planning;

import api.atlantis.domain.app.planning.HcPlanningItem;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface HcPlanningItemService extends BaseCrudService<HcPlanningItem> {
    List<HcPlanningItem> getPlanningItems(Long costCenterId, Long costAccTypeId);
}
