package main.java.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
public class Discipline {
    private int idDiscipline;
    private String name;
    private List<SkaterDiscipline> skaters;

    @Id
    @Column(name = "id_discipline", nullable = false, insertable = true, updatable = true)
    public int getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 30)
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

        if (idDiscipline != that.idDiscipline) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDiscipline;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "discipline")
    public List<SkaterDiscipline> getSkaters() {
        return skaters;
    }

    public void setSkaters(List<SkaterDiscipline> skaters) {
        this.skaters = skaters;
    }
}
