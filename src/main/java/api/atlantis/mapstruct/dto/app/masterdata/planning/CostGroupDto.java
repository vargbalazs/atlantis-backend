package api.atlantis.mapstruct.dto.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.mapstruct.validation.PK;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CostGroupDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("rowIndex")
    private int rowIndex;
    @JsonProperty("usedForPersPlanning")
    private boolean usedForPersPlanning;
    @JsonProperty("ohterPlantCost")
    private boolean ohterPlantCost;
    @JsonProperty("directWagesCost")
    private boolean directWagesCost;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("company")
    private Company company;
    @JsonProperty("companyId")
    private Long companyId;

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

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public boolean isUsedForPersPlanning() {
        return usedForPersPlanning;
    }

    public void setUsedForPersPlanning(boolean usedForPersPlanning) {
        this.usedForPersPlanning = usedForPersPlanning;
    }

    public boolean isOhterPlantCost() {
        return ohterPlantCost;
    }

    public void setOhterPlantCost(boolean ohterPlantCost) {
        this.ohterPlantCost = ohterPlantCost;
    }

    public boolean isDirectWagesCost() {
        return directWagesCost;
    }

    public void setDirectWagesCost(boolean directWagesCost) {
        this.directWagesCost = directWagesCost;
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
}
