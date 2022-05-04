package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.ActualCapacityPerCapGroup;

import java.util.List;

public interface ActualCapacityPerCapGroupService {
    List<ActualCapacityPerCapGroup> getActualCapacities(Long companyId, Long plantId, int year);
}
