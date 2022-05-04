package api.atlantis.domain.sp;

public class PlantPl {
    private Long costGroupId;
    private String costGroupName;
    private int rowIndex;
    private Long accountId;
    private String accountNumber;
    private String accountName;
    private int year;
    private int month;
    private Long budget;
    private double actual;
    private int frc;
    private double monthDiff;
    private double monthFrcDiff;
    private Long cumBudget;
    private double cumActual;
    private double cumDiff;

    public PlantPl() {
    }

    public PlantPl(Long costGroupId, String costGroupName, int rowIndex, Long accountId, String accountNumber,
                   String accountName, int year, int month, Long budget, double actual, int frc, double monthDiff,
                   double monthFrcDiff, Long cumBudget, double cumActual, double cumDiff) {
        this.costGroupId = costGroupId;
        this.costGroupName = costGroupName;
        this.rowIndex = rowIndex;
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.year = year;
        this.month = month;
        this.budget = budget;
        this.actual = actual;
        this.frc = frc;
        this.monthDiff = monthDiff;
        this.monthFrcDiff = monthFrcDiff;
        this.cumBudget = cumBudget;
        this.cumActual = cumActual;
        this.cumDiff = cumDiff;
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

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
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

    public int getFrc() {
        return frc;
    }

    public void setFrc(int frc) {
        this.frc = frc;
    }

    public double getMonthDiff() {
        return monthDiff;
    }

    public void setMonthDiff(double monthDiff) {
        this.monthDiff = monthDiff;
    }

    public double getMonthFrcDiff() {
        return monthFrcDiff;
    }

    public void setMonthFrcDiff(double monthFrcDiff) {
        this.monthFrcDiff = monthFrcDiff;
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
