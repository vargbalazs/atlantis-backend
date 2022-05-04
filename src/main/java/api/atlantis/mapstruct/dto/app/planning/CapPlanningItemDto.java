package api.atlantis.mapstruct.dto.app.planning;

import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CapPlanningItemDto {
    @NotNull(groups = {Existing.class})
    @JsonProperty("id")
    private Long id;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("companyId")
    private Long companyId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("plantId")
    private Long plantId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("costAccTypeId")
    private Long costAccTypeId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("year")
    private int year;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("capGroupId")
    private Long capGroupId;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p1")
    private int p1;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p2")
    private int p2;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p3")
    private int p3;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p4")
    private int p4;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p5")
    private int p5;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p6")
    private int p6;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p7")
    private int p7;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p8")
    private int p8;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p9")
    private int p9;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p10")
    private int p10;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p11")
    private int p11;
    @NotNull(groups = {New.class, Existing.class})
    @JsonProperty("p12")
    private int p12;

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

    public Long getCostAccTypeId() {
        return costAccTypeId;
    }

    public void setCostAccTypeId(Long costAccTypeId) {
        this.costAccTypeId = costAccTypeId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getCapGroupId() {
        return capGroupId;
    }

    public void setCapGroupId(Long capGroupId) {
        this.capGroupId = capGroupId;
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
