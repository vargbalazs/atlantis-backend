package api.atlantis.mapstruct.dto.app.planning;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAccountingTypeDto;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VersionDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("descr")
    private String descr;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("year")
    private int year;
    @JsonProperty("yearDate")
    private LocalDate yearDate;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("company")
    private Company company;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("plant")
    private PlantReducedDto plant;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("costAccType")
    private CostAccountingTypeDto costAccType;
    @JsonProperty("companyId")
    private Long companyId;
    @JsonProperty("plantId")
    private Long plantId;
    @JsonProperty("costAccTypeId")
    private Long costAccTypeId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("status")
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getYearDate() {
        return LocalDate.of(this.year, 1, 1);
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

    public PlantReducedDto getPlant() {
        return plant;
    }

    public void setPlant(PlantReducedDto plant) {
        this.plant = plant;
    }

    public CostAccountingTypeDto getCostAccType() {
        return costAccType;
    }

    public void setCostAccType(CostAccountingTypeDto costAccType) {
        this.costAccType = costAccType;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public Long getCostAccTypeId() {
        return costAccTypeId;
    }

    public void setCostAccTypeId(Long costAccTypeId) {
        this.costAccTypeId = costAccTypeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
