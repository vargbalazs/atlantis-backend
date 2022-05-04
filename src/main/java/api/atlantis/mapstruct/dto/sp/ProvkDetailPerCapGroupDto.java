package api.atlantis.mapstruct.dto.sp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProvkDetailPerCapGroupDto {
    @JsonProperty("capGroupId")
    private Long capGroupId;
    @JsonProperty("capGroup")
    private String capGroup;
    @JsonProperty("capName")
    private String capName;
    @JsonProperty("fixRate")
    private double fixRate;
    @JsonProperty("invNr")
    private String invNr;
    @JsonProperty("normalCap")
    private int normalCap;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("capTypeId")
    private Long capTypeId;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("provkId")
    private Long provkId;
    @JsonProperty("year")
    private int year;
    @JsonProperty("month")
    private int month;
    @JsonProperty("version")
    private int version;
    @JsonProperty("value")
    private int value;
    @JsonProperty("ba")
    private int ba;

    public Long getCapGroupId() {
        return capGroupId;
    }

    public void setCapGroupId(Long capGroupId) {
        this.capGroupId = capGroupId;
    }

    public String getCapGroup() {
        return capGroup;
    }

    public void setCapGroup(String capGroup) {
        this.capGroup = capGroup;
    }

    public String getCapName() {
        return capName;
    }

    public void setCapName(String capName) {
        this.capName = capName;
    }

    public double getFixRate() {
        return fixRate;
    }

    public void setFixRate(double fixRate) {
        this.fixRate = fixRate;
    }

    public String getInvNr() {
        return invNr;
    }

    public void setInvNr(String invNr) {
        this.invNr = invNr;
    }

    public int getNormalCap() {
        return normalCap;
    }

    public void setNormalCap(int normalCap) {
        this.normalCap = normalCap;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getCapTypeId() {
        return capTypeId;
    }

    public void setCapTypeId(Long capTypeId) {
        this.capTypeId = capTypeId;
    }

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
