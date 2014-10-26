package main.java.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
public class Pair {
    private int idPair;
    private String discipline;

    @Id
    @Column(name = "id_pair", nullable = false, insertable = true, updatable = true)
    public int getIdPair() {
        return idPair;
    }

    public void setIdPair(int idPair) {
        this.idPair = idPair;
    }

    @Basic
    @Column(name = "discipline", nullable = false, insertable = true, updatable = true, length = 30)
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

        if (idPair != pair.idPair) return false;
        if (discipline != null ? !discipline.equals(pair.discipline) : pair.discipline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPair;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        return result;
    }
}
