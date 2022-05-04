package api.atlantis.mapstruct.dto.app.masterdata.production;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantReducedDto;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CapGroupForProvkReducedDto extends CapGroupReducedDto {
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capTypeId")
    private Long capTypeId;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("capName")
    private String capName;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capUnit")
    private CapUnitReducedDto capUnit;
    @JsonProperty("capUnitId")
    private Long capUnitId;
    @NotEmpty(groups = {New.class, Existing.class})
    @JsonProperty("invNr")
    private String invNr;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capYear")
    private int capYear;
    @JsonProperty("capYearDate")
    private LocalDate capYearDate;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("normalCap")
    private int normalCap;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("fixRate")
    private double fixRate;

    public Long getCapTypeId() {
        return capTypeId;
    }

    public void setCapTypeId(Long capTypeId) {
        this.capTypeId = capTypeId;
    }

    @Override
    public String getCapName() {
        return capName;
    }

    @Override
    public void setCapName(String capName) {
        this.capName = capName;
    }

    public CapUnitReducedDto getCapUnit() {
        return capUnit;
    }

    public void setCapUnit(CapUnitReducedDto capUnit) {
        this.capUnit = capUnit;
    }

    public Long getCapUnitId() {
        return capUnitId;
    }

    public void setCapUnitId(Long capUnitId) {
        this.capUnitId = capUnitId;
    }

    public String getInvNr() {
        return invNr;
    }

    public void setInvNr(String invNr) {
        this.invNr = invNr;
    }

    public int getCapYear() {
        return capYear;
    }

    public void setCapYear(int capYear) {
        this.capYear = capYear;
    }

    public LocalDate getCapYearDate() {
        return capYearDate;
    }

    public void setCapYearDate(LocalDate capYearDate) {
        this.capYearDate = capYearDate;
    }

    public int getNormalCap() {
        return normalCap;
    }

    public void setNormalCap(int normalCap) {
        this.normalCap = normalCap;
    }

    public double getFixRate() {
        return fixRate;
    }

    public void setFixRate(double fixRate) {
        this.fixRate = fixRate;
    }
}
