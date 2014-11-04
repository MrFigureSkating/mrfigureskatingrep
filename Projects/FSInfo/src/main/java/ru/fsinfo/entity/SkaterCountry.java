package ru.fsinfo.entity;

import javax.persistence.*;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
@Table(name = "skater_country"/*, schema = "public", catalog = "FS3"*/)
public class SkaterCountry {
    private String idEvent;
    private Integer startSeason;
    private Integer finishSeason;
    private Country countryByShortName;
    private Pair pairByIdPair;
    private Skater skaterByIdSingle;

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

        SkaterCountry that = (SkaterCountry) o;

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
    @JoinColumn(name = "short_name", referencedColumnName = "short_name", nullable = false)
    public Country getCountryByShortName() {
        return countryByShortName;
    }

    public void setCountryByShortName(Country countryByShortName) {
        this.countryByShortName = countryByShortName;
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
}
