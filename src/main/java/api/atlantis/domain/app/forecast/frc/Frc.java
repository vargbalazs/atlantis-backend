package api.atlantis.domain.app.forecast.frc;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.domain.app.masterdata.planning.CostAccountingType;

import javax.persistence.*;

@Entity
public class Frc {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_frc")
    @SequenceGenerator(name = "seq_frc", allocationSize = 1)
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
    @JoinColumn(name="costAccTypeId", nullable = false)
    private CostAccountingType costAccType;
    private String version;
    private String comment;
    private boolean closed;
    private int va;
    private int ba;

    public Frc() {
    }

    public Frc(Long id, Company company, Plant plant, int year, CostAccountingType costAccType, String version,
               String comment, boolean closed, int va, int ba) {
        this.id = id;
        this.company = company;
        this.plant = plant;
        this.year = year;
        this.costAccType = costAccType;
        this.version = version;
        this.comment = comment;
        this.closed = closed;
        this.va = va;
        this.ba = ba;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getVa() {
        return va;
    }

    public void setVa(int va) {
        this.va = va;
    }

    public int getBa() {
        return ba;
    }

    public void setBa(int ba) {
        this.ba = ba;
    }
}
