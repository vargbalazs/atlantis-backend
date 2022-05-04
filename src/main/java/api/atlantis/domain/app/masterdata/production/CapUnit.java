package api.atlantis.domain.app.masterdata.production;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.general.Plant;

import javax.persistence.*;

@Entity
public class CapUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_capunit")
    @SequenceGenerator(name = "seq_capunit", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String unit;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;

    public CapUnit() {
    }

    public CapUnit(Long id, String unit, String name, Company company, Plant plant) {
        this.id = id;
        this.unit = unit;
        this.name = name;
        this.company = company;
        this.plant = plant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
