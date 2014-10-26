package main.java.entity;

import javax.persistence.*;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
@Table(name = "skater_discipline"/*, schema = "public", catalog = "FS"*/)
public class SkaterDiscipline {
    private int idEvent;
    private Integer startSeason;
    private Integer finishSeason;
    private Skater skater;
    private Discipline discipline;

    @Id
    @Column(name = "id_event", nullable = false, insertable = true, updatable = true)
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
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

        if (idEvent != that.idEvent) return false;
        if (finishSeason != null ? !finishSeason.equals(that.finishSeason) : that.finishSeason != null) return false;
        if (startSeason != null ? !startSeason.equals(that.startSeason) : that.startSeason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvent;
        result = 31 * result + (startSeason != null ? startSeason.hashCode() : 0);
        result = 31 * result + (finishSeason != null ? finishSeason.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", nullable = false)
    public Skater getSkater() {
        return skater;
    }

    public void setSkater(Skater skater) {
        this.skater = skater;
    }

    @ManyToOne
    @JoinColumn(name = "id_discipline", referencedColumnName = "id_discipline", nullable = false)
    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
