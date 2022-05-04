package api.atlantis.mapstruct.dto.sp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesDetailPerSalesProductDto {
    @JsonProperty("salesProductId")
    private Long salesProductId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("capGroupId")
    private Long capGroupId;
    @JsonProperty("capGroup")
    private String capGroup;
    @JsonProperty("capName")
    private String capName;
    @JsonProperty("unit")
    private String unit;
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

    public Long getSalesProductId() {
        return salesProductId;
    }

    public void setSalesProductId(Long salesProductId) {
        this.salesProductId = salesProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
}
