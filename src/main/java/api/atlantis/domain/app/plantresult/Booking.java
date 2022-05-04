package api.atlantis.domain.app.plantresult;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.domain.sp.PlantPl;

import javax.persistence.*;
import java.time.LocalDate;

@SqlResultSetMapping(
        name = "PlantPlMapping",
        classes = @ConstructorResult(
                targetClass = PlantPl.class,
                columns = {
                        @ColumnResult(name = "costgroupid", type = Long.class),
                        @ColumnResult(name = "costgroupname", type = String.class),
                        @ColumnResult(name = "rowindex", type = Integer.class),
                        @ColumnResult(name = "accountid", type = Long.class),
                        @ColumnResult(name = "accountnumber", type = String.class),
                        @ColumnResult(name = "accountname", type = String.class),
                        @ColumnResult(name = "year", type = Integer.class),
                        @ColumnResult(name = "month", type = Integer.class),
                        @ColumnResult(name = "budget", type = Long.class),
                        @ColumnResult(name = "actual", type = Double.class),
                        @ColumnResult(name = "frc", type = Integer.class),
                        @ColumnResult(name = "monthdiff", type = Double.class),
                        @ColumnResult(name = "monthfrcdiff", type = Double.class),
                        @ColumnResult(name = "cumbudget", type = Long.class),
                        @ColumnResult(name = "cumactual", type = Double.class),
                        @ColumnResult(name = "cumdiff", type = Double.class),
                }
        )
)
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_booking")
    @SequenceGenerator(name = "seq_booking", allocationSize = 100)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;
    private int year;
    private int month;
    private String costCenter;
    private String accountNumber;
    private String accountName;
    private double amount;
    private String currency;
    private double transAmount;
    private String transCur;
    private String bookingNr;
    private String refNr;
    private String bookingText;
    private String partnerObj;
    private String partnerObjName;
    private String contAccNumb;
    private String contAccName;
    private int period;
    private LocalDate bookingDate;
    private LocalDate docDate;
    private LocalDate postingDate;
    private String userName;

    public Booking() {
    }

    public Booking(Long id, Company company, Plant plant, int year, int month, String costCenter, String accountNumber,
                   String accountName, double amount, String currency, double transAmount, String transCur,
                   String bookingNr, String refNr, String bookingText, String partnerObj, String partnerObjName,
                   String contAccNumb, String contAccName, int period, LocalDate bookingDate, LocalDate docDate,
                   LocalDate postingDate, String userName) {
        this.id = id;
        this.company = company;
        this.plant = plant;
        this.year = year;
        this.month = month;
        this.costCenter = costCenter;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.amount = amount;
        this.currency = currency;
        this.transAmount = transAmount;
        this.transCur = transCur;
        this.bookingNr = bookingNr;
        this.refNr = refNr;
        this.bookingText = bookingText;
        this.partnerObj = partnerObj;
        this.partnerObjName = partnerObjName;
        this.contAccNumb = contAccNumb;
        this.contAccName = contAccName;
        this.period = period;
        this.bookingDate = bookingDate;
        this.docDate = docDate;
        this.postingDate = postingDate;
        this.userName = userName;
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

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransCur() {
        return transCur;
    }

    public void setTransCur(String transCur) {
        this.transCur = transCur;
    }

    public String getBookingNr() {
        return bookingNr;
    }

    public void setBookingNr(String bookingNr) {
        this.bookingNr = bookingNr;
    }

    public String getRefNr() {
        return refNr;
    }

    public void setRefNr(String refNr) {
        this.refNr = refNr;
    }

    public String getBookingText() {
        return bookingText;
    }

    public void setBookingText(String bookingText) {
        this.bookingText = bookingText;
    }

    public String getPartnerObj() {
        return partnerObj;
    }

    public void setPartnerObj(String partnerObj) {
        this.partnerObj = partnerObj;
    }

    public String getPartnerObjName() {
        return partnerObjName;
    }

    public void setPartnerObjName(String partnerObjName) {
        this.partnerObjName = partnerObjName;
    }

    public String getContAccNumb() {
        return contAccNumb;
    }

    public void setContAccNumb(String contAccNumb) {
        this.contAccNumb = contAccNumb;
    }

    public String getContAccName() {
        return contAccName;
    }

    public void setContAccName(String contAccName) {
        this.contAccName = contAccName;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
