package api.atlantis.service.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostCenter;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface CostCenterService extends BaseCrudService<CostCenter> {
    List<CostCenter> getCostCenters(Long plantId, int year);
}
