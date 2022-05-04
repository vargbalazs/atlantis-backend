package api.atlantis.domain.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.*;

import javax.persistence.*;

@Entity
public class CostCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_costcenter")
    @SequenceGenerator(name = "seq_costcenter", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String code;
    private String name;
    private int year;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantareaid", nullable = false)
    private PlantArea plantArea;

    public CostCenter() {
    }

    public CostCenter(Long id, String code, String name, int year, Company company, Plant plant, PlantArea plantArea) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.year = year;
        this.company = company;
        this.plant = plant;
        this.plantArea = plantArea;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public PlantArea getPlantArea() {
        return plantArea;
    }

    public void setPlantArea(PlantArea plantArea) {
        this.plantArea = plantArea;
    }
}
