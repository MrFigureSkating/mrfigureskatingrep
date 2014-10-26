package main.java.entity;

import javax.persistence.*;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
@Table(name = "skater_programs", schema = "public", catalog = "FS")
public class SkaterPrograms {
    private int idProgramSingleOrPairChor;
    private String discipline;
    private Integer season;
    private String type;

    @Id
    @Column(name = "id_program_single_or_pair_chor", nullable = false, insertable = true, updatable = true)
    public int getIdProgramSingleOrPairChor() {
        return idProgramSingleOrPairChor;
    }

    public void setIdProgramSingleOrPairChor(int idProgramSingleOrPairChor) {
        this.idProgramSingleOrPairChor = idProgramSingleOrPairChor;
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

        SkaterPrograms that = (SkaterPrograms) o;

        if (idProgramSingleOrPairChor != that.idProgramSingleOrPairChor) return false;
        if (discipline != null ? !discipline.equals(that.discipline) : that.discipline != null) return false;
        if (season != null ? !season.equals(that.season) : that.season != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProgramSingleOrPairChor;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
