package api.atlantis.domain.app.forecast.provk;

import api.atlantis.domain.app.masterdata.production.CapGroup;
import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;
import api.atlantis.domain.sp.ProvkDetailPerCapGroup;

import javax.persistence.*;
@SqlResultSetMapping(
        name = "ProvkDetailPerCapGroupMapping",
        classes = @ConstructorResult(
                targetClass = ProvkDetailPerCapGroup.class,
                columns = {
                        @ColumnResult(name = "capgroupid", type = Long.class),
                        @ColumnResult(name = "capgroup", type = String.class),
                        @ColumnResult(name = "capname", type = String.class),
                        @ColumnResult(name = "fixrate", type = Double.class),
                        @ColumnResult(name = "invnr", type = String.class),
                        @ColumnResult(name = "normalcap", type = Integer.class),
                        @ColumnResult(name = "unit", type = String.class),
                        @ColumnResult(name = "captypeid", type = Long.class),
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "provkid", type = Long.class),
                        @ColumnResult(name = "year", type = Integer.class),
                        @ColumnResult(name = "month", type = Integer.class),
                        @ColumnResult(name = "version", type = Integer.class),
                        @ColumnResult(name = "value", type = Integer.class),
                        @ColumnResult(name = "ba", type = Integer.class)
                }
        )
)
@Entity
public class ProvkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provk_detail")
    @SequenceGenerator(name = "seq_provk_detail", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="provkid", nullable = false)
    private Provk provk;
    private int year;
    private int month;
    private int version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="capgroupid", nullable = false)
    private CapGroup capGroup;
    private int value;
    private int ba;

    public ProvkDetail() {
    }

    public ProvkDetail(Long id, Provk provk, int year, int month, int version, CapGroup capGroup, int value, int ba) {
        this.id = id;
        this.provk = provk;
        this.year = year;
        this.month = month;
        this.version = version;
        this.capGroup = capGroup;
        this.value = value;
        this.ba = ba;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provk getProvk() {
        return provk;
    }

    public void setProvk(Provk provk) {
        this.provk = provk;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public CapGroup getCapGroup() {
        return capGroup;
    }

    public void setCapGroup(CapGroup capGroup) {
        this.capGroup = capGroup;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBa() {
        return ba;
    }

    public void setBa(int ba) {
        this.ba = ba;
    }
}
