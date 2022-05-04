package api.atlantis.mapstruct.dto.sp;

import api.atlantis.mapstruct.dto.app.masterdata.general.PlantAreaReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostCenterReducedDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CostCenterOverviewDto {
    @JsonProperty("plant")
    private PlantReducedDto plant;
    @JsonProperty("plantArea")
    private PlantAreaReducedDto plantArea;
    @JsonProperty("costCenter")
    private CostCenterReducedDto costCenter;
    @JsonProperty("year")
    private int year;
    @JsonProperty("month")
    private int month;
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

    public PlantReducedDto getPlant() {
        return plant;
    }

    public void setPlant(PlantReducedDto plant) {
        this.plant = plant;
    }

    public PlantAreaReducedDto getPlantArea() {
        return plantArea;
    }

    public void setPlantArea(PlantAreaReducedDto plantArea) {
        this.plantArea = plantArea;
    }

    public CostCenterReducedDto getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenterReducedDto costCenter) {
        this.costCenter = costCenter;
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
