package api.atlantis.mapstruct.dto.sp;

import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAccountReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostGroupReducedDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantPlDto {
    @JsonProperty("costGroup")
    private CostGroupReducedDto costGroup;
    @JsonProperty("costAccount")
    private CostAccountReducedDto costAccount;
    @JsonProperty("year")
    private int year;
    @JsonProperty("month")
    private int month;
    @JsonProperty("budget")
    private Long budget;
    @JsonProperty("actual")
    private double actual;
    @JsonProperty("frc")
    private double frc;
    @JsonProperty("monthDiff")
    private double monthDiff;
    @JsonProperty("monthFrcDiff")
    private double monthFrcDiff;
    @JsonProperty("cumBudget")
    private Long cumBudget;
    @JsonProperty("cumActual")
    private double cumActual;
    @JsonProperty("cumDiff")
    private double cumDiff;

    public CostGroupReducedDto getCostGroup() {
        return costGroup;
    }

    public void setCostGroup(CostGroupReducedDto costGroup) {
        this.costGroup = costGroup;
    }

    public CostAccountReducedDto getCostAccount() {
        return costAccount;
    }

    public void setCostAccount(CostAccountReducedDto costAccount) {
        this.costAccount = costAccount;
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

    public double getFrc() {
        return frc;
    }

    public void setFrc(double frc) {
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
