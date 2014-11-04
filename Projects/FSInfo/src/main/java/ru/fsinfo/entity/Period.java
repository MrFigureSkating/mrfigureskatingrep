package ru.fsinfo.entity;

import javax.persistence.*;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
public class Period {
    private String idEvent;
    private Integer startSeason;
    private Integer finishSeason;
    private Pair pairByIdPair;

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

        Period period = (Period) o;

        if (finishSeason != null ? !finishSeason.equals(period.finishSeason) : period.finishSeason != null)
            return false;
        if (idEvent != null ? !idEvent.equals(period.idEvent) : period.idEvent != null) return false;
        if (startSeason != null ? !startSeason.equals(period.startSeason) : period.startSeason != null) return false;

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
    @JoinColumn(name = "id_pair", referencedColumnName = "id_pair", nullable = false)
    public Pair getPairByIdPair() {
        return pairByIdPair;
    }

    public void setPairByIdPair(Pair pairByIdPair) {
        this.pairByIdPair = pairByIdPair;
    }
}
