package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.FrcCapacityPerCapGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrcCapacityPerCapGroupRepository {
    List<FrcCapacityPerCapGroup> getFrcCapacities(Long frcId, int year, Long plantId);
}
