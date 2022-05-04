package api.atlantis.mapstruct.dto.app.planning;

import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.planning.TaskService;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TaskDto {
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("taskName")
    private String taskName;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("taskStatus")
    private int taskStatus;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("planningItemId")
    private Long planningItemId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("taskType")
    private TaskService.TaskType taskType;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getPlanningItemId() {
        return planningItemId;
    }

    public void setPlanningItemId(Long planningItemId) {
        this.planningItemId = planningItemId;
    }

    public TaskService.TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskService.TaskType taskType) {
        this.taskType = taskType;
    }
}
