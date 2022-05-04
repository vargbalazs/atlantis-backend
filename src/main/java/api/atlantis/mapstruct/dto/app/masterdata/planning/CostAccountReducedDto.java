package api.atlantis.mapstruct.dto.app.masterdata.planning;

import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CostAccountReducedDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("accountNumber")
    private String accountNumber;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("fixRate")
    private double fixRate;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("varRate")
    private double varRate;
    @JsonProperty("usedForPersPlanning")
    private boolean usedForPersPlanning;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("year")
    private int year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFixRate() {
        return fixRate;
    }

    public void setFixRate(double fixRate) {
        this.fixRate = fixRate;
    }

    public double getVarRate() {
        return varRate;
    }

    public void setVarRate(double varRate) {
        this.varRate = varRate;
    }

    public boolean isUsedForPersPlanning() {
        return usedForPersPlanning;
    }

    public void setUsedForPersPlanning(boolean usedForPersPlanning) {
        this.usedForPersPlanning = usedForPersPlanning;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
