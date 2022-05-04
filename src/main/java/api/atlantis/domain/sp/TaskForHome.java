package api.atlantis.domain.sp;

public class TaskForHome {
    private String taskName;
    private int taskType;
    private String plantLocation;
    private String plantCode;
    private String costCenter;

    public TaskForHome() {
    }

    public TaskForHome(String taskName, int taskType, String plantLocation, String plantCode, String costCenter) {
        this.taskName = taskName;
        this.taskType = taskType;
        this.plantLocation = plantLocation;
        this.plantCode = plantCode;
        this.costCenter = costCenter;
    }

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
