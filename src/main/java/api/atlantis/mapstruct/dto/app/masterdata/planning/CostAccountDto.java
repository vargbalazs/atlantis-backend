package api.atlantis.mapstruct.dto.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.planning.CostGroup;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CostAccountDto {
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
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("yearDate")
    private LocalDate yearDate;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("company")
    private Company company;
    @JsonProperty("companyId")
    private Long companyId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("costGroup")
    private CostGroupReducedDto costGroup;
    @JsonProperty("costGroupId")
    private Long costGroupId;

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

    public LocalDate getYearDate() {
        return LocalDate.of(year, 1, 1);
    }

    public void setYearDate(LocalDate yearDate) {
        this.yearDate = yearDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CostGroupReducedDto getCostGroup() {
        return costGroup;
    }

    public void setCostGroup(CostGroupReducedDto costGroup) {
        this.costGroup = costGroup;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCostGroupId() {
        return costGroupId;
    }

    public void setCostGroupId(Long costGroupId) {
        this.costGroupId = costGroupId;
    }
}
