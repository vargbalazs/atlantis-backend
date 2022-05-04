package api.atlantis.mapstruct.dto.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.PK;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

public class PlantDto {
    @NotNull(groups = Existing.class)
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("code")
    private String code;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("location")
    private String location;
    @Valid
    @ConvertGroup.List({
            @ConvertGroup(from=New.class, to=PK.class),
            @ConvertGroup(from=Existing.class, to=PK.class)})
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
