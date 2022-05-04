package api.atlantis.domain.app.forecast.provk;

import api.atlantis.domain.app.masterdata.general.*;

import javax.persistence.*;

@Entity
public class ProvkVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provk_version")
    @SequenceGenerator(name = "seq_provk_version", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="provkid", nullable = false)
    private Provk provk;
    private int year;
    private int month;
    private int version;
    private int ba;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;

    public ProvkVersion() {
    }

    public ProvkVersion(Long id, Provk provk, int year, int month, int version, int ba, Company company, Plant plant) {
        this.id = id;
        this.provk = provk;
        this.year = year;
        this.month = month;
        this.version = version;
        this.ba = ba;
        this.company = company;
        this.plant = plant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provk getProvk() {
        return provk;
    }

    public void setProvk(Provk provk) {
        this.provk = provk;
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

    public int getBa() {
        return ba;
    }

    public void setBa(int ba) {
        this.ba = ba;
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
