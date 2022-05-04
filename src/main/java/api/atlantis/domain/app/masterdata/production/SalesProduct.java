package api.atlantis.domain.app.masterdata.production;

import api.atlantis.domain.app.masterdata.general.*;

import javax.persistence.*;

@Entity
public class SalesProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_salesproduct")
    @SequenceGenerator(name = "seq_salesproduct", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="capgroupid", nullable = false)
    private CapGroup capGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="unitid", nullable = false)
    private CapUnit unit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;
    private int year;

    public SalesProduct() {
    }

    public SalesProduct(Long id, String name, CapGroup capGroup, CapUnit unit, Company company, Plant plant, int year) {
        this.id = id;
        this.name = name;
        this.capGroup = capGroup;
        this.unit = unit;
        this.company = company;
        this.plant = plant;
        this.year = year;
    }

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

    public CapGroup getCapGroup() {
        return capGroup;
    }

    public void setCapGroup(CapGroup capGroup) {
        this.capGroup = capGroup;
    }

    public CapUnit getUnit() {
        return unit;
    }

    public void setUnit(CapUnit unit) {
        this.unit = unit;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
