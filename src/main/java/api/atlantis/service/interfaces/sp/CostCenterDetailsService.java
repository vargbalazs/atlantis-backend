package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.CostCenterDetails;

import java.util.List;

public interface CostCenterDetailsService {
    List<CostCenterDetails> getCostCenterDetails(int year, int month, Long costCenterId, Long costAccTypeId,
                                                 Long plantId, Long companyId);
}
