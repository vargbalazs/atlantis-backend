package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapPlanningItemPerCapGroupRepository  {
    List<CapPlanningItemPerCapGroup> getCapPlanningItems(Long companyId, Long plantId, int year, Long costAccTypeId);
}
