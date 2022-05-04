package api.atlantis.domain.app.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccount;

import javax.persistence.*;

@Entity
public class JobCost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jobcost")
    @SequenceGenerator(name = "seq_jobcost", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hcplanningitemid", nullable = false)
    private HcPlanningItem hcPlanningItem;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costaccountid", nullable = false)
    private CostAccount costAccount;
    private double amount;
    private int index;

    public JobCost() {
    }

    public JobCost(Long id, HcPlanningItem hcPlanningItem, CostAccount costAccount, double amount, int index) {
        this.id = id;
        this.hcPlanningItem = hcPlanningItem;
        this.costAccount = costAccount;
        this.amount = amount;
        this.index = index;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HcPlanningItem getHcPlanningItem() {
        return hcPlanningItem;
    }

    public void setHcPlanningItem(HcPlanningItem hcPlanningItem) {
        this.hcPlanningItem = hcPlanningItem;
    }

    public CostAccount getCostAccount() {
        return costAccount;
    }

    public void setCostAccount(CostAccount costAccount) {
        this.costAccount = costAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
