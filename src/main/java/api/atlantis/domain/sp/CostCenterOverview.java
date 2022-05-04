package api.atlantis.domain.sp;

public class CostCenterOverview {
    private Long plantId;
    private String plantCode;
    private Long plantAreaId;
    private String plantAreaCode;
    private Long costCenterId;
    private String costCenterCode;
    private String costCenterName;
    private int year;
    private int month;
    private Long budget;
    private double actual;
    private double monthDiff;
    private Long cumBudget;
    private double cumActual;
    private double cumDiff;

    public CostCenterOverview() {
    }

    public CostCenterOverview(Long plantId, String plantCode, Long plantAreaId, String plantAreaCode, Long costCenterId,
                              String costCenterCode, String costCenterName, int year, int month, Long budget,
                              double actual, double monthDiff, Long cumBudget, double cumActual, double cumDiff) {
        this.plantId = plantId;
        this.plantCode = plantCode;
        this.plantAreaId = plantAreaId;
        this.plantAreaCode = plantAreaCode;
        this.costCenterId = costCenterId;
        this.costCenterCode = costCenterCode;
        this.costCenterName = costCenterName;
        this.year = year;
        this.month = month;
        this.budget = budget;
        this.actual = actual;
        this.monthDiff = monthDiff;
        this.cumBudget = cumBudget;
        this.cumActual = cumActual;
        this.cumDiff = cumDiff;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public Long getPlantAreaId() {
        return plantAreaId;
    }

    public void setPlantAreaId(Long plantAreaId) {
        this.plantAreaId = plantAreaId;
    }

    public String getPlantAreaCode() {
        return plantAreaCode;
    }

    public void setPlantAreaCode(String plantAreaCode) {
        this.plantAreaCode = plantAreaCode;
    }

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getCostCenterName() {
        return costCenterName;
    }

    public void setCostCenterName(String costCenterName) {
        this.costCenterName = costCenterName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public double getActual() {
        return actual;
    }

    public void setActual(double actual) {
        this.actual = actual;
    }

    public double getMonthDiff() {
        return monthDiff;
    }

    public void setMonthDiff(double monthDiff) {
        this.monthDiff = monthDiff;
    }

    public Long getCumBudget() {
        return cumBudget;
    }

    public void setCumBudget(Long cumBudget) {
        this.cumBudget = cumBudget;
    }

    public double getCumActual() {
        return cumActual;
    }

    public void setCumActual(double cumActual) {
        this.cumActual = cumActual;
    }

    public double getCumDiff() {
        return cumDiff;
    }

    public void setCumDiff(double cumDiff) {
        this.cumDiff = cumDiff;
    }
}
