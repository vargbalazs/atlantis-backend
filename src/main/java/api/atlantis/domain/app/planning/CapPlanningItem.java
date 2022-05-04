package api.atlantis.domain.app.planning;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.domain.app.masterdata.planning.CostAccountingType;
import api.atlantis.domain.app.masterdata.production.CapGroup;
import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "CapPlanningItemPerCapGroupMapping",
        classes = @ConstructorResult(
                targetClass = CapPlanningItemPerCapGroup.class,
                columns = {
                        @ColumnResult(name = "capgroupid", type = Long.class),
                        @ColumnResult(name = "capgroup", type = String.class),
                        @ColumnResult(name = "capname", type = String.class),
                        @ColumnResult(name = "captype", type = String.class),
                        @ColumnResult(name = "year", type = Integer.class),
                        @ColumnResult(name = "plantid", type = Long.class),
                        @ColumnResult(name = "companyid", type = Long.class),
                        @ColumnResult(name = "unit", type = String.class),
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "costacctypeid", type = Long.class),
                        @ColumnResult(name = "p1", type = Integer.class),
                        @ColumnResult(name = "p2", type = Integer.class),
                        @ColumnResult(name = "p3", type = Integer.class),
                        @ColumnResult(name = "p4", type = Integer.class),
                        @ColumnResult(name = "p5", type = Integer.class),
                        @ColumnResult(name = "p6", type = Integer.class),
                        @ColumnResult(name = "p7", type = Integer.class),
                        @ColumnResult(name = "p8", type = Integer.class),
                        @ColumnResult(name = "p9", type = Integer.class),
                        @ColumnResult(name = "p10", type = Integer.class),
                        @ColumnResult(name = "p11", type = Integer.class),
                        @ColumnResult(name = "p12", type = Integer.class)
                }
        )
)
@Entity
public class CapPlanningItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_caplanning_item")
    @SequenceGenerator(name = "seq_caplanning_item", allocationSize = 1)
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
    @JoinColumn(name="capgroupid", nullable = false)
    private CapGroup capGroup;
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

    public CapPlanningItem() {
    }

    public CapPlanningItem(Long id, Company company, Plant plant, CostAccountingType costAccType, int year,
                           CapGroup capGroup, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9,
                           int p10, int p11, int p12) {
        this.id = id;
        this.company = company;
        this.plant = plant;
        this.costAccType = costAccType;
        this.year = year;
        this.capGroup = capGroup;
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

    public CapGroup getCapGroup() {
        return capGroup;
    }

    public void setCapGroup(CapGroup capGroup) {
        this.capGroup = capGroup;
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
}
