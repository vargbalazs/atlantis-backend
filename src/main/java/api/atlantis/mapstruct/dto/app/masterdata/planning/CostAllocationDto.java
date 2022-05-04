package api.atlantis.mapstruct.dto.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.domain.app.masterdata.planning.CostAccount;
import api.atlantis.domain.app.masterdata.planning.CostCenter;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantReducedDto;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CostAllocationDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("level")
    private int level;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("allocCostCenter")
    private CostCenterReducedDto allocCostCenter;
    @JsonProperty("allocCostCenterId")
    private Long allocCostCenterId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("costAccount")
    private CostAccountReducedDto costAccount;
    @JsonProperty("costAccountId")
    private Long costAccountId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("year")
    private int year;
    @JsonProperty("yearDate")
    private LocalDate yearDate;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("allocCapacity")
    private boolean allocCapacity;
    @JsonProperty("capacityUnit")
    private String capacityUnit;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("totalCapacity")
    private double totalCapacity;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CostCenterReducedDto getAllocCostCenter() {
        return allocCostCenter;
    }

    public void setAllocCostCenter(CostCenterReducedDto allocCostCenter) {
        this.allocCostCenter = allocCostCenter;
    }

    public Long getAllocCostCenterId() {
        return allocCostCenterId;
    }

    public void setAllocCostCenterId(Long allocCostCenterId) {
        this.allocCostCenterId = allocCostCenterId;
    }

    public CostAccountReducedDto getCostAccount() {
        return costAccount;
    }

    public void setCostAccount(CostAccountReducedDto costAccount) {
        this.costAccount = costAccount;
    }

    public Long getCostAccountId() {
        return costAccountId;
    }

    public void setCostAccountId(Long costAccountId) {
        this.costAccountId = costAccountId;
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

    public boolean isAllocCapacity() {
        return allocCapacity;
    }

    public void setAllocCapacity(boolean allocCapacity) {
        this.allocCapacity = allocCapacity;
    }

    public String getCapacityUnit() {
        return capacityUnit;
    }

    public void setCapacityUnit(String capacityUnit) {
        this.capacityUnit = capacityUnit;
    }

    public double getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(double totalCapacity) {
        this.totalCapacity = totalCapacity;
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
}
