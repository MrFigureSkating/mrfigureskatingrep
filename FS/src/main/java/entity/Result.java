package main.java.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
public class Result {
    private int idResult;
    private String discipline;
    private String country;
    private BigDecimal spScore;
    private Integer spPlace;
    private String spVideo;
    private BigDecimal fsScore;
    private Integer fsPlace;
    private String fsVideo;
    private Integer totalPlace;
    private String photo;
    private BigDecimal cdScore;
    private Integer cdPlace;
    private String cdVideo;

    @Id
    @Column(name = "id_result", nullable = false, insertable = true, updatable = true)
    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    @Basic
    @Column(name = "discipline", nullable = false, insertable = true, updatable = true, length = 30)
    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Basic
    @Column(name = "country", nullable = false, insertable = true, updatable = true, length = 30)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "sp_score", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSpScore() {
        return spScore;
    }

    public void setSpScore(BigDecimal spScore) {
        this.spScore = spScore;
    }

    @Basic
    @Column(name = "sp_place", nullable = true, insertable = true, updatable = true)
    public Integer getSpPlace() {
        return spPlace;
    }

    public void setSpPlace(Integer spPlace) {
        this.spPlace = spPlace;
    }

    @Basic
    @Column(name = "sp_video", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSpVideo() {
        return spVideo;
    }

    public void setSpVideo(String spVideo) {
        this.spVideo = spVideo;
    }

    @Basic
    @Column(name = "fs_score", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getFsScore() {
        return fsScore;
    }

    public void setFsScore(BigDecimal fsScore) {
        this.fsScore = fsScore;
    }

    @Basic
    @Column(name = "fs_place", nullable = true, insertable = true, updatable = true)
    public Integer getFsPlace() {
        return fsPlace;
    }

    public void setFsPlace(Integer fsPlace) {
        this.fsPlace = fsPlace;
    }

    @Basic
    @Column(name = "fs_video", nullable = true, insertable = true, updatable = true, length = 100)
    public String getFsVideo() {
        return fsVideo;
    }

    public void setFsVideo(String fsVideo) {
        this.fsVideo = fsVideo;
    }

    @Basic
    @Column(name = "total_place", nullable = true, insertable = true, updatable = true)
    public Integer getTotalPlace() {
        return totalPlace;
    }

    public void setTotalPlace(Integer totalPlace) {
        this.totalPlace = totalPlace;
    }

    @Basic
    @Column(name = "photo", nullable = true, insertable = true, updatable = true, length = 2000)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "cd_score", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getCdScore() {
        return cdScore;
    }

    public void setCdScore(BigDecimal cdScore) {
        this.cdScore = cdScore;
    }

    @Basic
    @Column(name = "cd_place", nullable = true, insertable = true, updatable = true)
    public Integer getCdPlace() {
        return cdPlace;
    }

    public void setCdPlace(Integer cdPlace) {
        this.cdPlace = cdPlace;
    }

    @Basic
    @Column(name = "cd_video", nullable = true, insertable = true, updatable = true, length = 100)
    public String getCdVideo() {
        return cdVideo;
    }

    public void setCdVideo(String cdVideo) {
        this.cdVideo = cdVideo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (idResult != result.idResult) return false;
        if (cdPlace != null ? !cdPlace.equals(result.cdPlace) : result.cdPlace != null) return false;
        if (cdScore != null ? !cdScore.equals(result.cdScore) : result.cdScore != null) return false;
        if (cdVideo != null ? !cdVideo.equals(result.cdVideo) : result.cdVideo != null) return false;
        if (country != null ? !country.equals(result.country) : result.country != null) return false;
        if (discipline != null ? !discipline.equals(result.discipline) : result.discipline != null) return false;
        if (fsPlace != null ? !fsPlace.equals(result.fsPlace) : result.fsPlace != null) return false;
        if (fsScore != null ? !fsScore.equals(result.fsScore) : result.fsScore != null) return false;
        if (fsVideo != null ? !fsVideo.equals(result.fsVideo) : result.fsVideo != null) return false;
        if (photo != null ? !photo.equals(result.photo) : result.photo != null) return false;
        if (spPlace != null ? !spPlace.equals(result.spPlace) : result.spPlace != null) return false;
        if (spScore != null ? !spScore.equals(result.spScore) : result.spScore != null) return false;
        if (spVideo != null ? !spVideo.equals(result.spVideo) : result.spVideo != null) return false;
        if (totalPlace != null ? !totalPlace.equals(result.totalPlace) : result.totalPlace != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idResult;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (spScore != null ? spScore.hashCode() : 0);
        result = 31 * result + (spPlace != null ? spPlace.hashCode() : 0);
        result = 31 * result + (spVideo != null ? spVideo.hashCode() : 0);
        result = 31 * result + (fsScore != null ? fsScore.hashCode() : 0);
        result = 31 * result + (fsPlace != null ? fsPlace.hashCode() : 0);
        result = 31 * result + (fsVideo != null ? fsVideo.hashCode() : 0);
        result = 31 * result + (totalPlace != null ? totalPlace.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (cdScore != null ? cdScore.hashCode() : 0);
        result = 31 * result + (cdPlace != null ? cdPlace.hashCode() : 0);
        result = 31 * result + (cdVideo != null ? cdVideo.hashCode() : 0);
        return result;
    }
}
