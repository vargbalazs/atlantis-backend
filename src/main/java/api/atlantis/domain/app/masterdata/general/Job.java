package api.atlantis.domain.app.masterdata.general;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_job")
    @SequenceGenerator(name = "seq_job", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String descr;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="depid", nullable = false)
    private Department department;

    public Job() {
    }

    public Job(Long id, String name, String descr, Department department) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.department = department;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
