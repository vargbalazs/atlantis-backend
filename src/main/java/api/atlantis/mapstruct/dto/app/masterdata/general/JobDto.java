package api.atlantis.mapstruct.dto.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("descr")
    private String descr;
    @JsonProperty("department")
    private Department department;
    @JsonProperty("depId")
    private Long depId;
    @JsonProperty("plant")
    private PlantReducedDto plant;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }
}
