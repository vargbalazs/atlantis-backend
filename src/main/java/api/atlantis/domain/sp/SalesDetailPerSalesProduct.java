package api.atlantis.domain.sp;

public class SalesDetailPerSalesProduct {
    private Long salesProductId;
    private String name;
    private Long capGroupId;
    private String capGroup;
    private String capName;
    private String unit;
    private Long id;
    private Long provkId;
    private int year;
    private int month;
    private int version;
    private int value;

    public SalesDetailPerSalesProduct() {
    }

    public SalesDetailPerSalesProduct(Long salesProductId, String name, Long capGroupId, String capGroup, String capName,
                                      String unit, Long id, Long provkId, int year, int month, int version, int value) {
        this.salesProductId = salesProductId;
        this.name = name;
        this.capGroupId = capGroupId;
        this.capGroup = capGroup;
        this.capName = capName;
        this.unit = unit;
        this.id = id;
        this.provkId = provkId;
        this.year = year;
        this.month = month;
        this.version = version;
        this.value = value;
    }

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


