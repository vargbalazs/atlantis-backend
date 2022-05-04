package api.atlantis.mapstruct.dto.app.planning;

import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class JobCostDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("hcPlanningItemId")
    private Long hcPlanningItemId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("costAccountId")
    private Long costAccountId;
    @JsonProperty("costAccountName")
    private String costAccountName;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("amount")
    private double amount;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("index")
    private int index;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHcPlanningItemId() {
        return hcPlanningItemId;
    }

    public void setHcPlanningItemId(Long hcPlanningItemId) {
        this.hcPlanningItemId = hcPlanningItemId;
    }

    public Long getCostAccountId() {
        return costAccountId;
    }

    public void setCostAccountId(Long costAccountId) {
        this.costAccountId = costAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCostAccountName() {
        return costAccountName;
    }

    public void setCostAccountName(String costAccountName) {
        this.costAccountName = costAccountName;
    }
}
