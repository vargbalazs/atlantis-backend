package api.atlantis.service.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostGroup;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface CostGroupService extends BaseCrudService<CostGroup> {
    List<CostGroup> getCostGroups(Long companyId);
}
