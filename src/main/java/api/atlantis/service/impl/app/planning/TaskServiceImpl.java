package api.atlantis.service.impl.app.planning;

import api.atlantis.domain.app.planning.CostPlanningItem;
import api.atlantis.domain.app.planning.HcPlanningItem;
import api.atlantis.domain.app.planning.Task;
import api.atlantis.repository.interfaces.app.planning.CostPlanningItemRepository;
import api.atlantis.repository.interfaces.app.planning.HcPlanningItemRepository;
import api.atlantis.service.interfaces.app.planning.TaskService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private CostPlanningItemRepository costPlanningItemRepository;
    private HcPlanningItemRepository hcPlanningItemRepository;

    public TaskServiceImpl(CostPlanningItemRepository costPlanningItemRepository,
                           HcPlanningItemRepository hcPlanningItemRepository) {
        this.costPlanningItemRepository = costPlanningItemRepository;
        this.hcPlanningItemRepository = hcPlanningItemRepository;
    }

    @Override
    public Long update(Task entity, Long planningItemId, TaskType taskType) {
        Task task = new Task(entity.getTaskName(), entity.getTaskStatus());
        switch (taskType) {
            case COST_PLANNING:
                CostPlanningItem costPlanningItem = costPlanningItemRepository.getById(planningItemId);
                costPlanningItem.setTask(task);
                costPlanningItemRepository.save(costPlanningItem);
                return planningItemId;
            case HC_PLANNING:
                HcPlanningItem hcPlanningItem = hcPlanningItemRepository.getById(planningItemId);
                hcPlanningItem.setTask(task);
                hcPlanningItemRepository.save(hcPlanningItem);
                return planningItemId;
        }
        return null;
    }

    @Override
    public Long addNew(Task entity) {
        return null;
    }

    @Override
    public Long update(Task entity) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

}
