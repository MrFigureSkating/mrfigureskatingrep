package main.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
@PrimaryKeyJoinColumn(name="id_person")
public class Choreographer {
    private int idPerson;

    @Id
    @Column(name = "id_person", nullable = false, insertable = true, updatable = true)
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Choreographer that = (Choreographer) o;

        if (idPerson != that.idPerson) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idPerson;
    }
}
