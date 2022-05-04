package api.atlantis.domain.app.masterdata.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plant")
    @SequenceGenerator(name = "seq_plant", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String code;
    private String location;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;

    public Plant() {
    }

    public Plant(Long id, String code, String location, Company company) {
        this.id = id;
        this.code = code;
        this.location = location;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}


