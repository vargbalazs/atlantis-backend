package api.atlantis.domain.app.masterdata.general;

import javax.persistence.*;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lang")
    @SequenceGenerator(name = "seq_lang", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String isoCode;
    private String name;
    private boolean defaultLang;

    public Language() {
    }

    public Language(Long id, String isoCode, String name, boolean defaultLang) {
        this.id = id;
        this.isoCode = isoCode;
        this.name = name;
        this.defaultLang = defaultLang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefaultLang() {
        return defaultLang;
    }

    public void setDefaultLang(boolean defaultLang) {
        this.defaultLang = defaultLang;
    }
}
