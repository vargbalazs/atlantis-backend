package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.CostCenterOverview;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostCenterOverviewRepository {
    List<CostCenterOverview> getCostCenterOverview(int year, int month, Long costAccTypeId, Long plantId);
}
