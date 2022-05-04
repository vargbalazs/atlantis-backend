package api.atlantis.domain.app.planning;

import api.atlantis.domain.app.masterdata.general.*;
import api.atlantis.domain.app.masterdata.planning.CostAccountingType;

import javax.persistence.*;

@Entity
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_version")
    @SequenceGenerator(name = "seq_version", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;
    private int year;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costacctypeid", nullable = false)
    private CostAccountingType costAccType;
    private String descr;
    private int status;

    public Version() {
    }

    public Version(Long id, Company company, Plant plant, int year, CostAccountingType costAccType, String descr,
                   int status) {
        this.id = id;
        this.company = company;
        this.plant = plant;
        this.year = year;
        this.costAccType = costAccType;
        this.descr = descr;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CostAccountingType getCostAccType() {
        return costAccType;
    }

    public void setCostAccType(CostAccountingType costAccType) {
        this.costAccType = costAccType;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
