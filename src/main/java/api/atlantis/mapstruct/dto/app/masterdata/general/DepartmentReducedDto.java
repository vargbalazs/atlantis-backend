package api.atlantis.mapstruct.dto.app.masterdata.general;

import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DepartmentReducedDto {
    @NotNull(groups = New.class)
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;

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

}
