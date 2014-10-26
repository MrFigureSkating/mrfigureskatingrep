package main.java.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
public class Period {
    private int idEvent;
    private Integer startSeason;
    private Integer finishSeason;

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

        Period period = (Period) o;

        if (idEvent != period.idEvent) return false;
        if (finishSeason != null ? !finishSeason.equals(period.finishSeason) : period.finishSeason != null)
            return false;
        if (startSeason != null ? !startSeason.equals(period.startSeason) : period.startSeason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvent;
        result = 31 * result + (startSeason != null ? startSeason.hashCode() : 0);
        result = 31 * result + (finishSeason != null ? finishSeason.hashCode() : 0);
        return result;
    }
}
