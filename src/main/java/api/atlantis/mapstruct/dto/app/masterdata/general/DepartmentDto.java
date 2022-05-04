package api.atlantis.mapstruct.dto.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.*;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.mapstruct.validation.Existing;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DepartmentDto {
    @NotNull(groups = New.class)
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("plant")
    private PlantReducedDto plant;
    @JsonProperty("plantId")
    private Long plantId;
    @JsonProperty("company")
    private Company company;

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

    public PlantReducedDto getPlant() {
        return plant;
    }

    public void setPlant(PlantReducedDto plant) {
        this.plant = plant;
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
}
