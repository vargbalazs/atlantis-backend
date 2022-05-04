package api.atlantis.domain.app.planning;

import javax.persistence.*;

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_currency")
    @SequenceGenerator(name = "seq_currency", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String isoCode;

    public Currency() {
    }

    public Currency(Long id, String isoCode) {
        this.id = id;
        this.isoCode = isoCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
