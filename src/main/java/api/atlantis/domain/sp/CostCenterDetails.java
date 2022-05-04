package api.atlantis.domain.sp;

public class CostCenterDetails {
    private Long costCenterId;
    private String costCenterCode;
    private String costCenterName;
    private Long costGroupId;
    private String costGroupName;
    private Long accountId;
    private String accountNumber;
    private String accountName;
    private Long budget;
    private double actual;
    private double monthDiff;
    private Long cumBudget;
    private double cumActual;
    private double cumDiff;

    public CostCenterDetails() {
    }

    public CostCenterDetails(Long costCenterId, String costCenterCode, String costCenterName, Long costGroupId,
                             String costGroupName, Long accountId, String accountNumber, String accountName,
                             Long budget, double actual, double monthDiff, Long cumBudget, double cumActual, double cumDiff) {
        this.costCenterId = costCenterId;
        this.costCenterCode = costCenterCode;
        this.costCenterName = costCenterName;
        this.costGroupId = costGroupId;
        this.costGroupName = costGroupName;
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.budget = budget;
        this.actual = actual;
        this.monthDiff = monthDiff;
        this.cumBudget = cumBudget;
        this.cumActual = cumActual;
        this.cumDiff = cumDiff;
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

    public Long getCostGroupId() {
        return costGroupId;
    }

    public void setCostGroupId(Long costGroupId) {
        this.costGroupId = costGroupId;
    }

    public String getCostGroupName() {
        return costGroupName;
    }

    public void setCostGroupName(String costGroupName) {
        this.costGroupName = costGroupName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
