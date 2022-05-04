package api.atlantis.mapstruct.dto.app.forecast.frc;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.planning.CostAccountingType;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantReducedDto;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class FrcDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @JsonProperty("companyId")
    private Long companyId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("company")
    private Company company;
    @JsonProperty("plantId")
    private Long plantId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("plant")
    private PlantReducedDto plant;
    @JsonProperty("costAccTypeId")
    private Long costAccTypeId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("costAccType")
    private CostAccountingType costAccType;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("year")
    private int year;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("version")
    private String version;
    @JsonProperty("comment")
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public PlantReducedDto getPlant() {
        return plant;
    }

    public void setPlant(PlantReducedDto plant) {
        this.plant = plant;
    }

    public Long getCostAccTypeId() {
        return costAccTypeId;
    }

    public void setCostAccTypeId(Long costAccTypeId) {
        this.costAccTypeId = costAccTypeId;
    }

    public CostAccountingType getCostAccType() {
        return costAccType;
    }

    public void setCostAccType(CostAccountingType costAccType) {
        this.costAccType = costAccType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
