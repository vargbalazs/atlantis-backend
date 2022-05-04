package api.atlantis.domain.app.masterdata.production;

import api.atlantis.domain.app.masterdata.general.*;

import javax.persistence.*;

@Entity
public class CapGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_capgroup")
    @SequenceGenerator(name = "seq_capgroup", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String capGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="captypeid", nullable = false)
    private CapType capType;
    private String capName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="capunitid", nullable = false)
    private CapUnit capUnit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;
    private String unit;
    private String invNr;
    private int capYear;
    private int normalCap;
    private double fixRate;

    public CapGroup() {
    }

    public CapGroup(Long id, String capGroup, CapType capType, String capName, CapUnit capUnit, Company company,
                    Plant plant, String unit, String invNr, int capYear, int normalCap, double fixRate) {
        this.id = id;
        this.capGroup = capGroup;
        this.capType = capType;
        this.capName = capName;
        this.capUnit = capUnit;
        this.company = company;
        this.plant = plant;
        this.unit = unit;
        this.invNr = invNr;
        this.capYear = capYear;
        this.normalCap = normalCap;
        this.fixRate = fixRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapGroup() {
        return capGroup;
    }

    public void setCapGroup(String capGroup) {
        this.capGroup = capGroup;
    }

    public CapType getCapType() {
        return capType;
    }

    public void setCapType(CapType capType) {
        this.capType = capType;
    }

    public String getCapName() {
        return capName;
    }

    public void setCapName(String capName) {
        this.capName = capName;
    }

    public CapUnit getCapUnit() {
        return capUnit;
    }

    public void setCapUnit(CapUnit capUnit) {
        this.capUnit = capUnit;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
