package api.atlantis.domain.sp;

public class ProvkDetailPerCapGroup {
    private Long capGroupId;
    private String capGroup;
    private String capName;
    private double fixRate;
    private String invNr;
    private int normalCap;
    private String unit;
    private Long capTypeId;
    private Long id;
    private Long provkId;
    private int year;
    private int month;
    private int version;
    private int value;
    private int ba;

    public ProvkDetailPerCapGroup() {
    }

    public ProvkDetailPerCapGroup(Long capGroupId, String capGroup, String capName, double fixRate, String invNr,
                                  int normalCap, String unit, Long capTypeId, Long id, Long provkId, int year,
                                  int month, int version, int value, int ba) {
        this.capGroupId = capGroupId;
        this.capGroup = capGroup;
        this.capName = capName;
        this.fixRate = fixRate;
        this.invNr = invNr;
        this.normalCap = normalCap;
        this.unit = unit;
        this.capTypeId = capTypeId;
        this.id = id;
        this.provkId = provkId;
        this.year = year;
        this.month = month;
        this.version = version;
        this.value = value;
        this.ba = ba;
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
