package api.atlantis.domain.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.*;

import javax.persistence.*;

@Entity
public class CostAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_costalloc")
    @SequenceGenerator(name = "seq_costalloc", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private int level;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="alloccostcenterid", nullable = false)
    private CostCenter allocCostCenter;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costaccountid", nullable = false)
    private CostAccount costAccount;
    private int year;
    private boolean allocCapacity;
    private String capacityUnit;
    private double totalCapacity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;

    public CostAllocation() {
    }

    public CostAllocation(Long id, String name, int level, CostCenter allocCostCenter, CostAccount costAccount,
                          int year, boolean allocCapacity, String capacityUnit, double totalCapacity, Company company,
                          Plant plant) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.allocCostCenter = allocCostCenter;
        this.costAccount = costAccount;
        this.year = year;
        this.allocCapacity = allocCapacity;
        this.capacityUnit = capacityUnit;
        this.totalCapacity = totalCapacity;
        this.company = company;
        this.plant = plant;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CostCenter getAllocCostCenter() {
        return allocCostCenter;
    }

    public void setAllocCostCenter(CostCenter allocCostCenter) {
        this.allocCostCenter = allocCostCenter;
    }

    public CostAccount getCostAccount() {
        return costAccount;
    }

    public void setCostAccount(CostAccount costAccount) {
        this.costAccount = costAccount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAllocCapacity() {
        return allocCapacity;
    }

    public void setAllocCapacity(boolean allocCapacity) {
        this.allocCapacity = allocCapacity;
    }

    public String getCapacityUnit() {
        return capacityUnit;
    }

    public void setCapacityUnit(String capacityUnit) {
        this.capacityUnit = capacityUnit;
    }

    public double getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(double totalCapacity) {
        this.totalCapacity = totalCapacity;
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
