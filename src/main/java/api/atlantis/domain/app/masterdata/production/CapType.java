package api.atlantis.domain.app.masterdata.production;

import api.atlantis.domain.app.masterdata.general.*;

import javax.persistence.*;

@Entity
public class CapType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_captype")
    @SequenceGenerator(name = "seq_captype", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String capType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;

    public CapType() {
    }

    public CapType(Long id, String capType, Company company, Plant plant) {
        this.id = id;
        this.capType = capType;
        this.company = company;
        this.plant = plant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapType() {
        return capType;
    }

    public void setCapType(String capType) {
        this.capType = capType;
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

