package api.atlantis.service.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocationDetail;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface CostAllocationDetailService extends BaseCrudService<CostAllocationDetail> {
    List<CostAllocationDetail> getDetailsByAllocId(Long id);
    void saveAll(List<CostAllocationDetail> costAllocationDetails);
    void deleteByCostAllocationId(Long id);
}
