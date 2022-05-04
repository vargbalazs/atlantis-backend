package api.atlantis.service.interfaces.app.planning;

import api.atlantis.domain.app.planning.Task;
import api.atlantis.service.interfaces.BaseCrudService;

public interface TaskService extends BaseCrudService<Task> {
    enum TaskType {
        COST_PLANNING,
        HC_PLANNING
    }

    Long update(Task entity, Long planningItemId, TaskType taskType);

}
