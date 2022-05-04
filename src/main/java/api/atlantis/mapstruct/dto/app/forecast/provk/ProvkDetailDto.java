package api.atlantis.mapstruct.dto.app.forecast.provk;

import api.atlantis.mapstruct.dto.app.masterdata.production.CapGroupForProvkReducedDto;
import api.atlantis.mapstruct.dto.app.masterdata.production.CapGroupReducedDto;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ProvkDetailDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("provkId")
    private Long provkId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("year")
    private int year;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("month")
    private int month;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("version")
    private int version;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capGroupId")
    private Long capGroupId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("value")
    private int value;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("ba")
    private int ba;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvkId() {
        return provkId;
    }

    public void setProvkId(Long provkId) {
        this.provkId = provkId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getCapGroupId() {
        return capGroupId;
    }

    public void setCapGroupId(Long capGroupId) {
        this.capGroupId = capGroupId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBa() {
        return ba;
    }

    public void setBa(int ba) {
        this.ba = ba;
    }

}
