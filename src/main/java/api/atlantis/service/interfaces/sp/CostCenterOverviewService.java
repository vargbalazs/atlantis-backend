package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.CostCenterOverview;

import java.util.List;

public interface CostCenterOverviewService {
    List<CostCenterOverview> getCostCenterOverview(int year, int month, Long costAccTypeId, Long plantId);
}
