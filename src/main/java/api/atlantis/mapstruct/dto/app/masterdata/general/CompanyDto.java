package api.atlantis.mapstruct.dto.app.masterdata.general;

import api.atlantis.mapstruct.validation.New;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.PK;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CompanyDto {
    @NotNull(groups = {Existing.class, PK.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("shortName")
    private String shortName;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
