package api.atlantis.domain.app.masterdata.planning;

import javax.persistence.*;

@Entity
public class CostAccountingType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_costaccounting_type")
    @SequenceGenerator(name = "seq_costaccounting_type", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String descr;

    public CostAccountingType() {
    }

    public CostAccountingType(Long id, String name, String descr) {
        this.id = id;
        this.name = name;
        this.descr = descr;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
