package main.java.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
public class Discipline {
    private String idDiscipline;
    private String name;
    private List<SkaterDiscipline> skaterDisciplinesByIdDiscipline;

    @Id
    @Column(name = "id_discipline", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(String idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discipline that = (Discipline) o;

        if (idDiscipline != null ? !idDiscipline.equals(that.idDiscipline) : that.idDiscipline != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDiscipline != null ? idDiscipline.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "disciplineByIdDiscipline")
    public List<SkaterDiscipline> getSkaterDisciplinesByIdDiscipline() {
        return skaterDisciplinesByIdDiscipline;
    }

    public void setSkaterDisciplinesByIdDiscipline(List<SkaterDiscipline> skaterDisciplinesByIdDiscipline) {
        this.skaterDisciplinesByIdDiscipline = skaterDisciplinesByIdDiscipline;
    }
}
