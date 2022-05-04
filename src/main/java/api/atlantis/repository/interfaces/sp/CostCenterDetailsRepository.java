package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.CostCenterDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostCenterDetailsRepository {
    List<CostCenterDetails> getCostCenterDetails(int year, int month, Long costCenterId, Long costAccTypeId,
                                                 Long plantId, Long companyId);
}
