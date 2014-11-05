package ru.fsinfo.entity;

import javax.persistence.*;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
public class Result {
    private String idResult;
    private String discipline;
    private String country;
    private String cdScore;
    private String cdPlace;
    private String cdVideo;
    private String spScore;
    private String spPlace;
    private String spVideo;
    private String fsScore;
    private String fsPlace;
    private String fsVideo;
    private String totalPlace;
    private String totalScore;
    private String photo;
    private Competition competitionByIdCompetition;
    private Pair pairByIdPair;
    private Skater skaterByIdSingle;
    private SkaterProgram skaterProgramByFsProgram;
    private SkaterProgram skaterProgramBySpProgram;
    private SkaterProgram skaterProgramByCdProgram;

    @Override
    public String toString() {
        return "Result{" +
                "idResult='" + idResult + '\'' +
                ", discipline='" + discipline + '\'' +
                ", country='" + country + '\'' +
                ", spScore='" + spScore + '\'' +
                ", spPlace='" + spPlace + '\'' +
                ", fsScore='" + fsScore + '\'' +
                ", fsPlace='" + fsPlace + '\'' +
                ", totalPlace='" + totalPlace + '\'' +
                ", totalScore='" + totalScore + '\'' +
                ", skaterByIdSingle=" + skaterByIdSingle +
                '}';
    }

    @Id
    @Column(name = "id_result", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdResult() {
        return idResult;
    }

    public void setIdResult(String idResult) {
        this.idResult = idResult;
    }

    @Basic
    @Column(name = "discipline", nullable = false, insertable = true, updatable = true, length = 32)
    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Basic
    @Column(name = "country", nullable = false, insertable = true, updatable = true, length = 32)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "cd_score", nullable = true, insertable = true, updatable = true, length = 6)
    public String getCdScore() {
        return cdScore;
    }

    public void setCdScore(String cdScore) {
        this.cdScore = cdScore;
    }

    @Basic
    @Column(name = "cd_place", nullable = true, insertable = true, updatable = true, length = 6)
    public String getCdPlace() {
        return cdPlace;
    }

    public void setCdPlace(String cdPlace) {
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

    @Basic
    @Column(name = "sp_score", nullable = true, insertable = true, updatable = true, length = 6)
    public String getSpScore() {
        return spScore;
    }

    public void setSpScore(String spScore) {
        this.spScore = spScore;
    }

    @Basic
    @Column(name = "sp_place", nullable = true, insertable = true, updatable = true, length = 6)
    public String getSpPlace() {
        return spPlace;
    }

    public void setSpPlace(String spPlace) {
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
    @Column(name = "fs_score", nullable = true, insertable = true, updatable = true, length = 6)
    public String getFsScore() {
        return fsScore;
    }

    public void setFsScore(String fsScore) {
        this.fsScore = fsScore;
    }

    @Basic
    @Column(name = "fs_place", nullable = true, insertable = true, updatable = true, length = 6)
    public String getFsPlace() {
        return fsPlace;
    }

    public void setFsPlace(String fsPlace) {
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
    @Column(name = "total_place", nullable = true, insertable = true, updatable = true, length = 6)
    public String getTotalPlace() {
        return totalPlace;
    }

    public void setTotalPlace(String totalPlace) {
        this.totalPlace = totalPlace;
    }

    @Basic
    @Column(name = "total_score", nullable = true, insertable = true, updatable = true, length = 6)
    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    @Basic
    @Column(name = "photo", nullable = true, insertable = true, updatable = true, length = 2000)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (cdPlace != null ? !cdPlace.equals(result.cdPlace) : result.cdPlace != null) return false;
        if (cdScore != null ? !cdScore.equals(result.cdScore) : result.cdScore != null) return false;
        if (cdVideo != null ? !cdVideo.equals(result.cdVideo) : result.cdVideo != null) return false;
        if (country != null ? !country.equals(result.country) : result.country != null) return false;
        if (discipline != null ? !discipline.equals(result.discipline) : result.discipline != null) return false;
        if (fsPlace != null ? !fsPlace.equals(result.fsPlace) : result.fsPlace != null) return false;
        if (fsScore != null ? !fsScore.equals(result.fsScore) : result.fsScore != null) return false;
        if (fsVideo != null ? !fsVideo.equals(result.fsVideo) : result.fsVideo != null) return false;
        if (idResult != null ? !idResult.equals(result.idResult) : result.idResult != null) return false;
        if (photo != null ? !photo.equals(result.photo) : result.photo != null) return false;
        if (spPlace != null ? !spPlace.equals(result.spPlace) : result.spPlace != null) return false;
        if (spScore != null ? !spScore.equals(result.spScore) : result.spScore != null) return false;
        if (spVideo != null ? !spVideo.equals(result.spVideo) : result.spVideo != null) return false;
        if (totalPlace != null ? !totalPlace.equals(result.totalPlace) : result.totalPlace != null) return false;
        if (totalScore != null ? !totalScore.equals(result.totalScore) : result.totalScore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idResult != null ? idResult.hashCode() : 0;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (cdScore != null ? cdScore.hashCode() : 0);
        result = 31 * result + (cdPlace != null ? cdPlace.hashCode() : 0);
        result = 31 * result + (cdVideo != null ? cdVideo.hashCode() : 0);
        result = 31 * result + (spScore != null ? spScore.hashCode() : 0);
        result = 31 * result + (spPlace != null ? spPlace.hashCode() : 0);
        result = 31 * result + (spVideo != null ? spVideo.hashCode() : 0);
        result = 31 * result + (fsScore != null ? fsScore.hashCode() : 0);
        result = 31 * result + (fsPlace != null ? fsPlace.hashCode() : 0);
        result = 31 * result + (fsVideo != null ? fsVideo.hashCode() : 0);
        result = 31 * result + (totalPlace != null ? totalPlace.hashCode() : 0);
        result = 31 * result + (totalScore != null ? totalScore.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_competition", referencedColumnName = "id_competition", nullable = false)
    public Competition getCompetitionByIdCompetition() {
        return competitionByIdCompetition;
    }

    public void setCompetitionByIdCompetition(Competition competitionByIdCompetition) {
        this.competitionByIdCompetition = competitionByIdCompetition;
    }

    @ManyToOne
    @JoinColumn(name = "id_pair", referencedColumnName = "id_pair")
    public Pair getPairByIdPair() {
        return pairByIdPair;
    }

    public void setPairByIdPair(Pair pairByIdPair) {
        this.pairByIdPair = pairByIdPair;
    }

    @ManyToOne
    @JoinColumn(name = "id_single", referencedColumnName = "id_skater")
    public Skater getSkaterByIdSingle() {
        return skaterByIdSingle;
    }

    public void setSkaterByIdSingle(Skater skaterByIdSingle) {
        this.skaterByIdSingle = skaterByIdSingle;
    }

    @ManyToOne
    @JoinColumn(name = "fs_program", referencedColumnName = "id_program_single_or_pair_chore")
    public SkaterProgram getSkaterProgramByFsProgram() {
        return skaterProgramByFsProgram;
    }

    public void setSkaterProgramByFsProgram(SkaterProgram skaterProgramByFsProgram) {
        this.skaterProgramByFsProgram = skaterProgramByFsProgram;
    }

    @ManyToOne
    @JoinColumn(name = "sp_program", referencedColumnName = "id_program_single_or_pair_chore")
    public SkaterProgram getSkaterProgramBySpProgram() {
        return skaterProgramBySpProgram;
    }

    public void setSkaterProgramBySpProgram(SkaterProgram skaterProgramBySpProgram) {
        this.skaterProgramBySpProgram = skaterProgramBySpProgram;
    }

    @ManyToOne
    @JoinColumn(name = "cd_program", referencedColumnName = "id_program_single_or_pair_chore")
    public SkaterProgram getSkaterProgramByCdProgram() {
        return skaterProgramByCdProgram;
    }

    public void setSkaterProgramByCdProgram(SkaterProgram skaterProgramByCdProgram) {
        this.skaterProgramByCdProgram = skaterProgramByCdProgram;
    }
}
