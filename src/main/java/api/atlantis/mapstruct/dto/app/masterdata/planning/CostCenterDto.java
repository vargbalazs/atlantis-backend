package api.atlantis.mapstruct.dto.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.domain.app.masterdata.general.PlantArea;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantAreaReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantReducedDto;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CostCenterDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("code")
    private String code;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;
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
    @JsonProperty("plant")
    private PlantReducedDto plant;
    @JsonProperty("plantId")
    private Long plantId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("plantArea")
    private PlantAreaReducedDto plantArea;
    @JsonProperty("plantAreaId")
    private Long plantAreaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public PlantAreaReducedDto getPlantArea() {
        return plantArea;
    }

    public void setPlantArea(PlantAreaReducedDto plantArea) {
        this.plantArea = plantArea;
    }

    public LocalDate getYearDate() {
        return LocalDate.of(year, 1, 1);
    }

    public void setYearDate(LocalDate yearDate) {
        this.yearDate = yearDate;
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

    public Long getPlantAreaId() {
        return plantAreaId;
    }

    public void setPlantAreaId(Long plantAreaId) {
        this.plantAreaId = plantAreaId;
    }
}
