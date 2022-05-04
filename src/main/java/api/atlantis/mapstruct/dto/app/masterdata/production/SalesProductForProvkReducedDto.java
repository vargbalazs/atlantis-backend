package api.atlantis.mapstruct.dto.app.masterdata.production;

import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SalesProductForProvkReducedDto {
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("unit")
    private CapUnitReducedDto unit;
    @JsonProperty("unitId")
    private Long unitId;

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

    public CapUnitReducedDto getUnit() {
        return unit;
    }

    public void setUnit(CapUnitReducedDto unit) {
        this.unit = unit;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
}
