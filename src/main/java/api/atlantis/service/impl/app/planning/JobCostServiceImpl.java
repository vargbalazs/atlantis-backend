package api.atlantis.service.impl.app.planning;

import api.atlantis.domain.app.planning.HcPlanningItem;
import api.atlantis.domain.app.planning.JobCost;
import api.atlantis.repository.interfaces.app.planning.HcPlanningItemRepository;
import api.atlantis.repository.interfaces.app.planning.JobCostRepository;
import api.atlantis.service.interfaces.app.planning.JobCostService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobCostServiceImpl implements JobCostService {
    private JobCostRepository jobCostRepository;
    private HcPlanningItemRepository hcPlanningItemRepository;

    public JobCostServiceImpl(JobCostRepository jobCostRepository, HcPlanningItemRepository hcPlanningItemRepository) {
        this.jobCostRepository = jobCostRepository;
        this.hcPlanningItemRepository = hcPlanningItemRepository;
    }

    @Override
    public Long addNew(JobCost entity) {
        return null;
    }

    @Override
    public Long update(JobCost entity) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<JobCost> getAll() {
        return null;
    }

    @Override
    public List<JobCost> getJobCosts(Long hcPlanningItemId) {
        return jobCostRepository.findByHcPlanningItemId(hcPlanningItemId);
    }

    @Override
    public void saveAll(List<JobCost> jobCosts, Long hcPlanningItemId) {
        List<JobCost> originalJobCosts = getJobCosts(hcPlanningItemId);
        for (JobCost originalJobCost : originalJobCosts) {
            if (!jobCosts.stream().anyMatch(detail -> detail.getId() == originalJobCost.getId())) {
                jobCostRepository.deleteById(originalJobCost.getId());
            }
        }
        if (!jobCosts.isEmpty()) jobCostRepository.saveAll(jobCosts);

        boolean costAssigned = !jobCosts.isEmpty();
        HcPlanningItem hcPlanningItem = hcPlanningItemRepository.getById(hcPlanningItemId);
        hcPlanningItem.setCostAssigned(costAssigned);
        hcPlanningItemRepository.save(hcPlanningItem);
    }
}
