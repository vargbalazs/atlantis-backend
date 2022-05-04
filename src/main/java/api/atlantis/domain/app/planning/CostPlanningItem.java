package api.atlantis.domain.app.planning;

import api.atlantis.domain.app.masterdata.general.*;
import api.atlantis.domain.app.masterdata.planning.*;
import api.atlantis.domain.sp.CostCenterDetails;
import api.atlantis.domain.sp.CostCenterOverview;
import api.atlantis.domain.sp.TaskForHome;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "CostCenterOverviewMapping",
        classes = @ConstructorResult(
                targetClass = CostCenterOverview.class,
                columns = {
                        @ColumnResult(name = "plantid", type = Long.class),
                        @ColumnResult(name = "plantcode", type = String.class),
                        @ColumnResult(name = "plantareaid", type = Long.class),
                        @ColumnResult(name = "plantareacode", type = String.class),
                        @ColumnResult(name = "costcenterid", type = Long.class),
                        @ColumnResult(name = "costcentercode", type = String.class),
                        @ColumnResult(name = "costcentername", type = String.class),
                        @ColumnResult(name = "year", type = Integer.class),
                        @ColumnResult(name = "month", type = Integer.class),
                        @ColumnResult(name = "budget", type = Long.class),
                        @ColumnResult(name = "actual", type = Double.class),
                        @ColumnResult(name = "monthdiff", type = Double.class),
                        @ColumnResult(name = "cumbudget", type = Long.class),
                        @ColumnResult(name = "cumactual", type = Double.class),
                        @ColumnResult(name = "cumdiff", type = Double.class),
                }
        )
)
@SqlResultSetMapping(
        name = "CostCenterDetailsMapping",
        classes = @ConstructorResult(
                targetClass = CostCenterDetails.class,
                columns = {
                        @ColumnResult(name = "costcenterid", type = Long.class),
                        @ColumnResult(name = "costcentercode", type = String.class),
                        @ColumnResult(name = "costcentername", type = String.class),
                        @ColumnResult(name = "costgroupid", type = Long.class),
                        @ColumnResult(name = "costgroupname", type = String.class),
                        @ColumnResult(name = "accountid", type = Long.class),
                        @ColumnResult(name = "accountnumber", type = String.class),
                        @ColumnResult(name = "accountname", type = String.class),
                        @ColumnResult(name = "budget", type = Long.class),
                        @ColumnResult(name = "actual", type = Double.class),
                        @ColumnResult(name = "monthdiff", type = Double.class),
                        @ColumnResult(name = "cumbudget", type = Long.class),
                        @ColumnResult(name = "cumactual", type = Double.class),
                        @ColumnResult(name = "cumdiff", type = Double.class),
                }
        )
)
@SqlResultSetMapping(
        name = "TaskForHomeMapping",
        classes = @ConstructorResult(
                targetClass = TaskForHome.class,
                columns = {
                        @ColumnResult(name = "taskName", type = String.class),
                        @ColumnResult(name = "taskType", type = Integer.class),
                        @ColumnResult(name = "plantLocation", type = String.class),
                        @ColumnResult(name = "plantCode", type = String.class),
                        @ColumnResult(name = "costCenter", type = String.class),
                }
        )
)
@Entity
public class CostPlanningItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_costplanning_item")
    @SequenceGenerator(name = "seq_costplanning_item", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costacctypeid", nullable = false)
    private CostAccountingType costAccType;
    private int year;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costcenterid", nullable = false)
    private CostCenter costCenter;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costgroupid", nullable = false)
    private CostGroup costGroup;
    private String itemName;
    private int amountInCurrency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="currencyid", nullable = false)
    private Currency currency;
    private int amount;
    private int distribution;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costaccountid", nullable = false)
    private CostAccount costAccount;
    private int p1;
    private int p2;
    private int p3;
    private int p4;
    private int p5;
    private int p6;
    private int p7;
    private int p8;
    private int p9;
    private int p10;
    private int p11;
    private int p12;
    @Embedded
    private Task task;

    public CostPlanningItem() {
    }

    public CostPlanningItem(Long id, Company company, Plant plant, CostAccountingType costAccType, int year,
                            CostCenter costCenter, CostGroup costGroup, String itemName, int amountInCurrency,
                            Currency currency, int amount, int distribution, String comment, CostAccount costAccount,
                            int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11,
                            int p12, Task task) {
        this.id = id;
        this.company = company;
        this.plant = plant;
        this.costAccType = costAccType;
        this.year = year;
        this.costCenter = costCenter;
        this.costGroup = costGroup;
        this.itemName = itemName;
        this.amountInCurrency = amountInCurrency;
        this.currency = currency;
        this.amount = amount;
        this.distribution = distribution;
        this.comment = comment;
        this.costAccount = costAccount;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
        this.p10 = p10;
        this.p11 = p11;
        this.p12 = p12;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CostAccountingType getCostAccType() {
        return costAccType;
    }

    public void setCostAccType(CostAccountingType costAccType) {
        this.costAccType = costAccType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public CostGroup getCostGroup() {
        return costGroup;
    }

    public void setCostGroup(CostGroup costGroup) {
        this.costGroup = costGroup;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmountInCurrency() {
        return amountInCurrency;
    }

    public void setAmountInCurrency(int amountInCurrency) {
        this.amountInCurrency = amountInCurrency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDistribution() {
        return distribution;
    }

    public void setDistribution(int distribution) {
        this.distribution = distribution;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CostAccount getCostAccount() {
        return costAccount;
    }

    public void setCostAccount(CostAccount costAccount) {
        this.costAccount = costAccount;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public int getP4() {
        return p4;
    }

    public void setP4(int p4) {
        this.p4 = p4;
    }

    public int getP5() {
        return p5;
    }

    public void setP5(int p5) {
        this.p5 = p5;
    }

    public int getP6() {
        return p6;
    }

    public void setP6(int p6) {
        this.p6 = p6;
    }

    public int getP7() {
        return p7;
    }

    public void setP7(int p7) {
        this.p7 = p7;
    }

    public int getP8() {
        return p8;
    }

    public void setP8(int p8) {
        this.p8 = p8;
    }

    public int getP9() {
        return p9;
    }

    public void setP9(int p9) {
        this.p9 = p9;
    }

    public int getP10() {
        return p10;
    }

    public void setP10(int p10) {
        this.p10 = p10;
    }

    public int getP11() {
        return p11;
    }

    public void setP11(int p11) {
        this.p11 = p11;
    }

    public int getP12() {
        return p12;
    }

    public void setP12(int p12) {
        this.p12 = p12;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
