package ru.fsinfo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
@Table(name = "skater_program"/*, schema = "public", catalog = "FS3"*/)
public class SkaterProgram {
    private String idProgramSingleOrPairChore;
    private String discipline;
    private Integer season;
    private String type;
    private List<Result> resultsByIdProgramSingleOrPairChore;
    private List<Result> resultsByIdProgramSingleOrPairChore_0;
    private List<Result> resultsByIdProgramSingleOrPairChore_1;
    private Choreographer choreographerByIdChoreographer;
    private Pair pairByIdPair;
    private Program programByIdProgram;
    private Skater skaterByIdSingle;

    @Id
    @Column(name = "id_program_single_or_pair_chore", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdProgramSingleOrPairChore() {
        return idProgramSingleOrPairChore;
    }

    public void setIdProgramSingleOrPairChore(String idProgramSingleOrPairChore) {
        this.idProgramSingleOrPairChore = idProgramSingleOrPairChore;
    }

    @Basic
    @Column(name = "discipline", nullable = true, insertable = true, updatable = true, length = 32)
    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Basic
    @Column(name = "season", nullable = true, insertable = true, updatable = true)
    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    @Basic
    @Column(name = "type", nullable = true, insertable = true, updatable = true, length = 2)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkaterProgram that = (SkaterProgram) o;

        if (discipline != null ? !discipline.equals(that.discipline) : that.discipline != null) return false;
        if (idProgramSingleOrPairChore != null ? !idProgramSingleOrPairChore.equals(that.idProgramSingleOrPairChore) : that.idProgramSingleOrPairChore != null)
            return false;
        if (season != null ? !season.equals(that.season) : that.season != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProgramSingleOrPairChore != null ? idProgramSingleOrPairChore.hashCode() : 0;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "skaterProgramByFsProgram")
    public List<Result> getResultsByIdProgramSingleOrPairChore() {
        return resultsByIdProgramSingleOrPairChore;
    }

    public void setResultsByIdProgramSingleOrPairChore(List<Result> resultsByIdProgramSingleOrPairChore) {
        this.resultsByIdProgramSingleOrPairChore = resultsByIdProgramSingleOrPairChore;
    }

    @OneToMany(mappedBy = "skaterProgramBySpProgram")
    public List<Result> getResultsByIdProgramSingleOrPairChore_0() {
        return resultsByIdProgramSingleOrPairChore_0;
    }

    public void setResultsByIdProgramSingleOrPairChore_0(List<Result> resultsByIdProgramSingleOrPairChore_0) {
        this.resultsByIdProgramSingleOrPairChore_0 = resultsByIdProgramSingleOrPairChore_0;
    }

    @OneToMany(mappedBy = "skaterProgramByCdProgram")
    public List<Result> getResultsByIdProgramSingleOrPairChore_1() {
        return resultsByIdProgramSingleOrPairChore_1;
    }

    public void setResultsByIdProgramSingleOrPairChore_1(List<Result> resultsByIdProgramSingleOrPairChore_1) {
        this.resultsByIdProgramSingleOrPairChore_1 = resultsByIdProgramSingleOrPairChore_1;
    }

    @ManyToOne
    @JoinColumn(name = "id_choreographer", referencedColumnName = "id_choreographer", nullable = false)
    public Choreographer getChoreographerByIdChoreographer() {
        return choreographerByIdChoreographer;
    }

    public void setChoreographerByIdChoreographer(Choreographer choreographerByIdChoreographer) {
        this.choreographerByIdChoreographer = choreographerByIdChoreographer;
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
    @JoinColumn(name = "id_program", referencedColumnName = "id_program", nullable = false)
    public Program getProgramByIdProgram() {
        return programByIdProgram;
    }

    public void setProgramByIdProgram(Program programByIdProgram) {
        this.programByIdProgram = programByIdProgram;
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
