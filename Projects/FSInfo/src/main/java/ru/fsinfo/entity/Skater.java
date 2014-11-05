package ru.fsinfo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
@PrimaryKeyJoinColumn(name="id_skater")
public class Skater extends Person {
//    private String idSkater;
    private List<Pair> pairsByIdMan;
    private List<Pair> pairsByIdLady;
    private List<Result> resultsByIdSkater;
//    private Person personByIdSkater;
    private List<SkaterCoach> skaterCoachesByIdSkater;
    private List<SkaterCountry> skaterCountriesByIdSkater;
    private List<SkaterDiscipline> skaterDisciplinesByIdSkater;
    private List<SkaterProgram> skaterProgramsByIdSkater;

//    @Id
//    @Column(name = "id_skater", nullable = false, insertable = true, updatable = true, length = 32)
//    public String getIdSkater() {
//        return idSkater;
//    }
//
//    public void setIdSkater(String idSkater) {
//        this.idSkater = idSkater;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skater skater = (Skater) o;

        if (getIdPerson() != null ? !getIdPerson().equals(skater.getIdPerson()) : skater.getIdPerson() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getIdPerson() != null ? getIdPerson().hashCode() : 0;
    }

    @OneToMany(mappedBy = "skaterByIdLady",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public List<Pair> getPairsByIdMan() {
        return pairsByIdMan;
    }

    public void setPairsByIdMan(List<Pair> pairsByIdMan) {
        this.pairsByIdMan = pairsByIdMan;
    }

    @OneToMany(mappedBy = "skaterByIdMan",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public List<Pair> getPairsByIdLady() {
        return pairsByIdLady;
    }

    public void setPairsByIdLady(List<Pair> pairsByIdLady) {
        this.pairsByIdLady = pairsByIdLady;
    }

    @OneToMany(mappedBy = "skaterByIdSingle")
    public List<Result> getResultsByIdSkater() {
        return resultsByIdSkater;
    }

    public void setResultsByIdSkater(List<Result> resultsByIdSkater) {
        this.resultsByIdSkater = resultsByIdSkater;
    }

//    @OneToOne
//    @JoinColumn(name = "id_skater", referencedColumnName = "id_person", nullable = false)
//    public Person getPersonByIdSkater() {
//        return personByIdSkater;
//    }
//
//    public void setPersonByIdSkater(Person personByIdSkater) {
//        this.personByIdSkater = personByIdSkater;
//    }

    @OneToMany(mappedBy = "skaterByIdSingle")
    public List<SkaterCoach> getSkaterCoachesByIdSkater() {
        return skaterCoachesByIdSkater;
    }

    public void setSkaterCoachesByIdSkater(List<SkaterCoach> skaterCoachesByIdSkater) {
        this.skaterCoachesByIdSkater = skaterCoachesByIdSkater;
    }

    @OneToMany(mappedBy = "skaterByIdSingle")
    public List<SkaterCountry> getSkaterCountriesByIdSkater() {
        return skaterCountriesByIdSkater;
    }

    public void setSkaterCountriesByIdSkater(List<SkaterCountry> skaterCountriesByIdSkater) {
        this.skaterCountriesByIdSkater = skaterCountriesByIdSkater;
    }

    @OneToMany(mappedBy = "skaterByIdSkater")
    public List<SkaterDiscipline> getSkaterDisciplinesByIdSkater() {
        return skaterDisciplinesByIdSkater;
    }

    public void setSkaterDisciplinesByIdSkater(List<SkaterDiscipline> skaterDisciplinesByIdSkater) {
        this.skaterDisciplinesByIdSkater = skaterDisciplinesByIdSkater;
    }

    @OneToMany(mappedBy = "skaterByIdSingle")
    public List<SkaterProgram> getSkaterProgramsByIdSkater() {
        return skaterProgramsByIdSkater;
    }

    public void setSkaterProgramsByIdSkater(List<SkaterProgram> skaterProgramsByIdSkater) {
        this.skaterProgramsByIdSkater = skaterProgramsByIdSkater;
    }
}
