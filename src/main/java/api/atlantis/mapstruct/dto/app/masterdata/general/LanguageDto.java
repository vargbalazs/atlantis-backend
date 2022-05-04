package api.atlantis.mapstruct.dto.app.masterdata.general;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("isoCode")
    private String isoCode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("defaultLang")
    private boolean defaultLang;

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
