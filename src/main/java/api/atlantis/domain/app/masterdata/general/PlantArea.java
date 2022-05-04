package api.atlantis.domain.app.masterdata.general;

import javax.persistence.*;

@Entity
public class PlantArea {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plantarea")
    @SequenceGenerator(name = "seq_plantarea", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String code;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;

    public PlantArea() {
    }

    public PlantArea(Long id, String code, String name, Plant plant) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.plant = plant;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

}
