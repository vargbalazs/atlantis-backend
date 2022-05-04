package api.atlantis.domain.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.Company;

import javax.persistence.*;

@Entity
public class CostAllocationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_costalloc_detail")
    @SequenceGenerator(name = "seq_costalloc_detail", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costallocid", nullable = false)
    private CostAllocation costAllocation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="basecostcenterid", nullable = false)
    private CostCenter baseCostCenter;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="reccostcenterid", nullable = false)
    private CostCenter recCostCenter;
    private double percent;
    private double capacity;
    private int index;

    public CostAllocationDetail() {
    }

    public CostAllocationDetail(Long id, CostAllocation costAllocation, CostCenter baseCostCenter,
                                CostCenter recCostCenter, double percent, double capacity, int index) {
        this.id = id;
        this.costAllocation = costAllocation;
        this.baseCostCenter = baseCostCenter;
        this.recCostCenter = recCostCenter;
        this.percent = percent;
        this.capacity = capacity;
        this.index = index;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CostAllocation getCostAllocation() {
        return costAllocation;
    }

    public void setCostAllocation(CostAllocation costAllocation) {
        this.costAllocation = costAllocation;
    }

    public CostCenter getBaseCostCenter() {
        return baseCostCenter;
    }

    public void setBaseCostCenter(CostCenter baseCostCenter) {
        this.baseCostCenter = baseCostCenter;
    }

    public CostCenter getRecCostCenter() {
        return recCostCenter;
    }

    public void setRecCostCenter(CostCenter recCostCenter) {
        this.recCostCenter = recCostCenter;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
