package ru.fsinfo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
public class Pair {
    private String idPair;
    private String discipline;
    private Skater skaterByIdLady;
    private Skater skaterByIdMan;
    private List<Period> periodsByIdPair;
    private List<Result> resultsByIdPair;
    private List<SkaterCoach> skaterCoachesByIdPair;
    private List<SkaterCountry> skaterCountriesByIdPair;
    private List<SkaterProgram> skaterProgramsByIdPair;

    @Id
    @Column(name = "id_pair", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdPair() {
        return idPair;
    }

    public void setIdPair(String idPair) {
        this.idPair = idPair;
    }

    @Basic
    @Column(name = "discipline", nullable = false, insertable = true, updatable = true, length = 32)
    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (discipline != null ? !discipline.equals(pair.discipline) : pair.discipline != null) return false;
        if (idPair != null ? !idPair.equals(pair.idPair) : pair.idPair != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPair != null ? idPair.hashCode() : 0;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lady", referencedColumnName = "id_skater", nullable = false)
    public Skater getSkaterByIdLady() {
        return skaterByIdLady;
    }

    public void setSkaterByIdLady(Skater skaterByIdLady) {
        this.skaterByIdLady = skaterByIdLady;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_man", referencedColumnName = "id_skater", nullable = false)
    public Skater getSkaterByIdMan() {
        return skaterByIdMan;
    }

    public void setSkaterByIdMan(Skater skaterByIdMan) {
        this.skaterByIdMan = skaterByIdMan;
    }

    @OneToMany(mappedBy = "pairByIdPair")
    public List<Period> getPeriodsByIdPair() {
        return periodsByIdPair;
    }

    public void setPeriodsByIdPair(List<Period> periodsByIdPair) {
        this.periodsByIdPair = periodsByIdPair;
    }

    @OneToMany(mappedBy = "pairByIdPair")
    public List<Result> getResultsByIdPair() {
        return resultsByIdPair;
    }

    public void setResultsByIdPair(List<Result> resultsByIdPair) {
        this.resultsByIdPair = resultsByIdPair;
    }

    @OneToMany(mappedBy = "pairByIdPair")
    public List<SkaterCoach> getSkaterCoachesByIdPair() {
        return skaterCoachesByIdPair;
    }

    public void setSkaterCoachesByIdPair(List<SkaterCoach> skaterCoachesByIdPair) {
        this.skaterCoachesByIdPair = skaterCoachesByIdPair;
    }

    @OneToMany(mappedBy = "pairByIdPair")
    public List<SkaterCountry> getSkaterCountriesByIdPair() {
        return skaterCountriesByIdPair;
    }

    public void setSkaterCountriesByIdPair(List<SkaterCountry> skaterCountriesByIdPair) {
        this.skaterCountriesByIdPair = skaterCountriesByIdPair;
    }

    @OneToMany(mappedBy = "pairByIdPair")
    public List<SkaterProgram> getSkaterProgramsByIdPair() {
        return skaterProgramsByIdPair;
    }

    public void setSkaterProgramsByIdPair(List<SkaterProgram> skaterProgramsByIdPair) {
        this.skaterProgramsByIdPair = skaterProgramsByIdPair;
    }
}
