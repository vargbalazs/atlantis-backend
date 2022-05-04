package api.atlantis.domain.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.Company;

import javax.persistence.*;

@Entity
public class CostGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_costgroup")
    @SequenceGenerator(name = "seq_costgroup", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private int rowIndex;
    private boolean usedForPersPlanning;
    private boolean ohterPlantCost;
    private boolean directWagesCost;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;

    public CostGroup() {
    }

    public CostGroup(Long id, String name, int rowIndex, boolean usedForPersPlanning, boolean ohterPlantCost,
                     boolean directWagesCost, Company company) {
        this.id = id;
        this.name = name;
        this.rowIndex = rowIndex;
        this.usedForPersPlanning = usedForPersPlanning;
        this.ohterPlantCost = ohterPlantCost;
        this.directWagesCost = directWagesCost;
        this.company = company;
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

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public boolean isUsedForPersPlanning() {
        return usedForPersPlanning;
    }

    public void setUsedForPersPlanning(boolean usedForPersPlanning) {
        this.usedForPersPlanning = usedForPersPlanning;
    }

    public boolean isOhterPlantCost() {
        return ohterPlantCost;
    }

    public void setOhterPlantCost(boolean ohterPlantCost) {
        this.ohterPlantCost = ohterPlantCost;
    }

    public boolean isDirectWagesCost() {
        return directWagesCost;
    }

    public void setDirectWagesCost(boolean directWagesCost) {
        this.directWagesCost = directWagesCost;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
