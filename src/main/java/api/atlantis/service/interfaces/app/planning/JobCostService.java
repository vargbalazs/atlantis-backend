package api.atlantis.service.interfaces.app.planning;

import api.atlantis.domain.app.planning.JobCost;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface JobCostService extends BaseCrudService<JobCost> {
    List<JobCost> getJobCosts(Long hcPlanningItemId);
    void saveAll(List<JobCost> jobCosts, Long hcPlanningItemId);
}
