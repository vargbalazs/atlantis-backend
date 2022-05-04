package api.atlantis.mapstruct.dto.app.masterdata.production;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantReducedDto;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CapGroupDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("capGroup")
    private String capGroup;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capType")
    private CapTypeReducedDto capType;
    @JsonProperty("capTypeId")
    private Long capTypeId;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("capName")
    private String capName;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capUnit")
    private CapUnitReducedDto capUnit;
    @JsonProperty("capUnitId")
    private Long capUnitId;
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
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("unit")
    private String unit;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("invNr")
    private String invNr;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capYear")
    private int capYear;
    @JsonProperty("capYearDate")
    private LocalDate capYearDate;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("normalCap")
    private int normalCap;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("fixRate")
    private double fixRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapGroup() {
        return capGroup;
    }

    public void setCapGroup(String capGroup) {
        this.capGroup = capGroup;
    }

    public CapTypeReducedDto getCapType() {
        return capType;
    }

    public void setCapType(CapTypeReducedDto capType) {
        this.capType = capType;
    }

    public Long getCapTypeId() {
        return capTypeId;
    }

    public void setCapTypeId(Long capTypeId) {
        this.capTypeId = capTypeId;
    }

    public String getCapName() {
        return capName;
    }

    public void setCapName(String capName) {
        this.capName = capName;
    }

    public CapUnitReducedDto getCapUnit() {
        return capUnit;
    }

    public void setCapUnit(CapUnitReducedDto capUnit) {
        this.capUnit = capUnit;
    }

    public Long getCapUnitId() {
        return capUnitId;
    }

    public void setCapUnitId(Long capUnitId) {
        this.capUnitId = capUnitId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public PlantReducedDto getPlant() {
        return plant;
    }

    public void setPlant(PlantReducedDto plant) {
        this.plant = plant;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getInvNr() {
        return invNr;
    }

    public void setInvNr(String invNr) {
        this.invNr = invNr;
    }

    public int getCapYear() {
        return capYear;
    }

    public void setCapYear(int capYear) {
        this.capYear = capYear;
    }

    public LocalDate getCapYearDate() {
        return LocalDate.of(this.capYear, 1, 1);
    }

    public void setCapYearDate(LocalDate capYearDate) {
        this.capYearDate = capYearDate;
    }

    public int getNormalCap() {
        return normalCap;
    }

    public void setNormalCap(int normalCap) {
        this.normalCap = normalCap;
    }

    public double getFixRate() {
        return fixRate;
    }

    public void setFixRate(double fixRate) {
        this.fixRate = fixRate;
    }
}
