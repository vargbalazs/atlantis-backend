package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.ActualCapacityPerCapGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActualCapacityPerCapGroupRepository {
    List<ActualCapacityPerCapGroup> getActualCapacities(Long companyId, Long plantId, int year);
}
