package api.atlantis.mapstruct.dto.sp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskForHomeDto {
    @JsonProperty("taskName")
    private String taskName;
    @JsonProperty("taskType")
    private int taskType;
    @JsonProperty("plantLocation")
    private String plantLocation;
    @JsonProperty("plantCode")
    private String plantCode;
    @JsonProperty("costCenter")
    private String costCenter;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getPlantLocation() {
        return plantLocation;
    }

    public void setPlantLocation(String plantLocation) {
        this.plantLocation = plantLocation;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }
}
