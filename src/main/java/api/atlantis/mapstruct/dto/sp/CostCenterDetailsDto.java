package api.atlantis.mapstruct.dto.sp;

import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAccountReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostCenterReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostGroupReducedDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CostCenterDetailsDto {
    @JsonProperty("costCenter")
    private CostCenterReducedDto costCenter;
    @JsonProperty("costGroup")
    private CostGroupReducedDto costGroup;
    @JsonProperty("costAccount")
    private CostAccountReducedDto costAccount;
    @JsonProperty("budget")
    private Long budget;
    @JsonProperty("actual")
    private double actual;
    @JsonProperty("monthDiff")
    private double monthDiff;
    @JsonProperty("cumBudget")
    private Long cumBudget;
    @JsonProperty("cumActual")
    private double cumActual;
    @JsonProperty("cumDiff")
    private double cumDiff;

    public CostCenterReducedDto getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenterReducedDto costCenter) {
        this.costCenter = costCenter;
    }

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
