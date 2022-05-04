package api.atlantis.domain.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.general.*;

import javax.persistence.*;

@Entity
public class CostResp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_costresp")
    @SequenceGenerator(name = "seq_costresp", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="langid", nullable = false)
    private Language lang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costcenterid", nullable = false)
    private CostCenter costCenter;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="depid", nullable = false)
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="jobid", nullable = false)
    private Job job;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plantid", nullable = false)
    private Plant plant;

    public CostResp() {
    }

    public CostResp(Long id, String name, String email, Language lang, CostCenter costCenter, Department department,
                    Job job, Company company, Plant plant) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lang = lang;
        this.costCenter = costCenter;
        this.department = department;
        this.job = job;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
