package main.java.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
public class CitizenshipPK implements Serializable {
    private String shortName;
    private int idPerson;

    @Column(name = "short_name", nullable = false, insertable = true, updatable = true, length = 3)
    @Id
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Column(name = "id_person", nullable = false, insertable = true, updatable = true)
    @Id
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

        CitizenshipPK that = (CitizenshipPK) o;

        if (idPerson != that.idPerson) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shortName != null ? shortName.hashCode() : 0;
        result = 31 * result + idPerson;
        return result;
    }
}
