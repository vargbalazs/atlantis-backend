package api.atlantis.mapstruct.dto.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocation;
import api.atlantis.domain.app.masterdata.planning.CostCenter;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CostAllocationDetailDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("costAllocation")
    private CostAllocationReducedDto costAllocation;
    @JsonProperty("costAllocId")
    private Long costAllocId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("baseCostCenter")
    private CostCenterReducedDto baseCostCenter;
    @JsonProperty("baseCostCenterId")
    private Long baseCostCenterId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("recCostCenter")
    private CostCenterReducedDto recCostCenter;
    @JsonProperty("recCostCenterId")
    private Long recCostCenterId;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("recCostCenterName")
    private String recCostCenterName;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("percent")
    private double percent;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capacity")
    private double capacity;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("index")
    private int index;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CostAllocationReducedDto getCostAllocation() {
        return costAllocation;
    }

    public void setCostAllocation(CostAllocationReducedDto costAllocation) {
        this.costAllocation = costAllocation;
    }

    public Long getCostAllocId() {
        return costAllocId;
    }

    public void setCostAllocId(Long costAllocId) {
        this.costAllocId = costAllocId;
    }

    public CostCenterReducedDto getBaseCostCenter() {
        return baseCostCenter;
    }

    public void setBaseCostCenter(CostCenterReducedDto baseCostCenter) {
        this.baseCostCenter = baseCostCenter;
    }

    public Long getBaseCostCenterId() {
        return baseCostCenterId;
    }

    public void setBaseCostCenterId(Long baseCostCenterId) {
        this.baseCostCenterId = baseCostCenterId;
    }

    public CostCenterReducedDto getRecCostCenter() {
        return recCostCenter;
    }

    public void setRecCostCenter(CostCenterReducedDto recCostCenter) {
        this.recCostCenter = recCostCenter;
    }

    public Long getRecCostCenterId() {
        return recCostCenterId;
    }

    public void setRecCostCenterId(Long recCostCenterId) {
        this.recCostCenterId = recCostCenterId;
    }

    public String getRecCostCenterName() {
        return this.recCostCenter.getName();
    }

    public void setRecCostCenterName(String recCostCenterName) {
        this.recCostCenterName = recCostCenterName;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
