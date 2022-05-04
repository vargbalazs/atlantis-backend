package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.FrcCapacityPerCapGroup;

import java.util.List;

public interface FrcCapacityPerCapGroupService {
    List<FrcCapacityPerCapGroup> getFrcCapacities(Long frcId, int year, Long plantId);
}
