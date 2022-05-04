package api.atlantis.mapstruct.dto.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.*;
import api.atlantis.domain.app.masterdata.planning.CostCenter;
import api.atlantis.mapstruct.dto.app.masterdata.general.DepartmentReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.general.JobReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantReducedDto;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CostRespDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("name")
    private String name;
    @NotEmpty(groups = {New.class, Existing.class})
    @Email(groups = {New.class, Existing.class})
    @JsonProperty("email")
    private String email;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("lang")
    private Language lang;
    @JsonProperty("langId")
    private Long langId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("costCenter")
    private CostCenterReducedDto costCenter;
    @JsonProperty("costCenterId")
    private Long costCenterId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("department")
    private DepartmentReducedDto department;
    @JsonProperty("depId")
    private Long depId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("job")
    private JobReducedDto job;
    @JsonProperty("jobId")
    private Long jobId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("company")
    private Company company;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("plant")
    private PlantReducedDto plant;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public Long getLangId() {
        return langId;
    }

    public void setLangId(Long langId) {
        this.langId = langId;
    }

    public CostCenterReducedDto getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenterReducedDto costCenter) {
        this.costCenter = costCenter;
    }

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public DepartmentReducedDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentReducedDto department) {
        this.department = department;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public JobReducedDto getJob() {
        return job;
    }

    public void setJob(JobReducedDto job) {
        this.job = job;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public PlantReducedDto getPlant() {
        return plant;
    }

    public void setPlant(PlantReducedDto plant) {
        this.plant = plant;
    }
}
