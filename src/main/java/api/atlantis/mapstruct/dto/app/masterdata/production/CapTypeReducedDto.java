package api.atlantis.mapstruct.dto.app.masterdata.production;

import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CapTypeReducedDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("capType")
    private String capType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapType() {
        return capType;
    }

    public void setCapType(String capType) {
        this.capType = capType;
    }
}
