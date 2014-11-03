package main.java.entity;

import javax.persistence.*;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
@Table(name = "skater_discipline"/*, schema = "public", catalog = "FS3"*/)
public class SkaterDiscipline {
    private String idEvent;
    private Integer startSeason;
    private Integer finishSeason;
    private Discipline disciplineByIdDiscipline;
    private Skater skaterByIdSkater;

    @Id
    @Column(name = "id_event", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    @Basic
    @Column(name = "start_season", nullable = true, insertable = true, updatable = true)
    public Integer getStartSeason() {
        return startSeason;
    }

    public void setStartSeason(Integer startSeason) {
        this.startSeason = startSeason;
    }

    @Basic
    @Column(name = "finish_season", nullable = true, insertable = true, updatable = true)
    public Integer getFinishSeason() {
        return finishSeason;
    }

    public void setFinishSeason(Integer finishSeason) {
        this.finishSeason = finishSeason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkaterDiscipline that = (SkaterDiscipline) o;

        if (finishSeason != null ? !finishSeason.equals(that.finishSeason) : that.finishSeason != null) return false;
        if (idEvent != null ? !idEvent.equals(that.idEvent) : that.idEvent != null) return false;
        if (startSeason != null ? !startSeason.equals(that.startSeason) : that.startSeason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvent != null ? idEvent.hashCode() : 0;
        result = 31 * result + (startSeason != null ? startSeason.hashCode() : 0);
        result = 31 * result + (finishSeason != null ? finishSeason.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_discipline", referencedColumnName = "id_discipline", nullable = false)
    public Discipline getDisciplineByIdDiscipline() {
        return disciplineByIdDiscipline;
    }

    public void setDisciplineByIdDiscipline(Discipline disciplineByIdDiscipline) {
        this.disciplineByIdDiscipline = disciplineByIdDiscipline;
    }

    @ManyToOne
    @JoinColumn(name = "id_skater", referencedColumnName = "id_skater", nullable = false)
    public Skater getSkaterByIdSkater() {
        return skaterByIdSkater;
    }

    public void setSkaterByIdSkater(Skater skaterByIdSkater) {
        this.skaterByIdSkater = skaterByIdSkater;
    }
}
