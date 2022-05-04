package api.atlantis.domain.app.masterdata.general;

import javax.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company")
    @SequenceGenerator(name = "seq_company", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String shortName;

    public Company() {
    }

    public Company(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
