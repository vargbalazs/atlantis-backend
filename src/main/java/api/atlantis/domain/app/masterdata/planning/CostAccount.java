package api.atlantis.domain.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.Company;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CostAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_costaccount")
    @SequenceGenerator(name = "seq_costaccount", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String accountNumber;
    private String name;
    private double fixRate;
    private double varRate;
    private boolean usedForPersPlanning;
    private int year;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costgroupid", nullable = false)
    private CostGroup costGroup;

    public CostAccount() {
    }

    public CostAccount(Long id, String accountNumber, String name, double fixRate, double varRate,
                       boolean usedForPersPlanning, int year, Company company, CostGroup costGroup) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.fixRate = fixRate;
        this.varRate = varRate;
        this.usedForPersPlanning = usedForPersPlanning;
        this.year = year;
        this.company = company;
        this.costGroup = costGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFixRate() {
        return fixRate;
    }

    public void setFixRate(double fixRate) {
        this.fixRate = fixRate;
    }

    public double getVarRate() {
        return varRate;
    }

    public void setVarRate(double varRate) {
        this.varRate = varRate;
    }

    public boolean isUsedForPersPlanning() {
        return usedForPersPlanning;
    }

    public void setUsedForPersPlanning(boolean usedForPersPlanning) {
        this.usedForPersPlanning = usedForPersPlanning;
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

    public CostGroup getCostGroup() {
        return costGroup;
    }

    public void setCostGroup(CostGroup costGroup) {
        this.costGroup = costGroup;
    }
}



