package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;
import java.util.List;

public interface CapPlanningItemPerCapGroupService {
    List<CapPlanningItemPerCapGroup> getCapPlanningItems(Long companyId, Long plantId, int year, Long costAccTypeId);
}
