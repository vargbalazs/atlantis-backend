package api.atlantis.domain.app.forecast.provk;

import api.atlantis.domain.app.masterdata.general.*;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Provk {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provk")
    @SequenceGenerator(name = "seq_provk", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;
    private int year;
    private int month;
    private int versions;
    private Date period;

    public Provk() {
    }

    public Provk(Long id, Company company, Plant plant, int year, int month, int versions, Date period) {
        this.id = id;
        this.company = company;
        this.plant = plant;
        this.year = year;
        this.month = month;
        this.versions = versions;
        this.period = period;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getVersions() {
        return versions;
    }

    public void setVersions(int versions) {
        this.versions = versions;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }
}
