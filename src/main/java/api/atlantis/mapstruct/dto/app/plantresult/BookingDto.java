package api.atlantis.mapstruct.dto.app.plantresult;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

public class BookingDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("companyId")
    private Long companyId;
    @JsonProperty("plantId")
    private Long plantId;
    @JsonProperty("year")
    private int year;
    @JsonProperty("month")
    private int month;
    @JsonProperty("costCenter")
    private String costCenter;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("accountName")
    private String accountName;
    @JsonProperty("amount")
    private double amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("transAmount")
    private double transAmount;
    @JsonProperty("transCur")
    private String transCur;
    @JsonProperty("bookingNr")
    private String bookingNr;
    @JsonProperty("refNr")
    private String refNr;
    @JsonProperty("bookingText")
    private String bookingText;
    @JsonProperty("partnerObj")
    private String partnerObj;
    @JsonProperty("partnerObjName")
    private String partnerObjName;
    @JsonProperty("contAccNumb")
    private String contAccNumb;
    @JsonProperty("contAccName")
    private String contAccName;
    @JsonProperty("period")
    private int period;
    @JsonProperty("bookingDate")
    private LocalDate bookingDate;
    @JsonProperty("docDate")
    private LocalDate docDate;
    @JsonProperty("postingDate")
    private LocalDate postingDate;
    @JsonProperty("userName")
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
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
