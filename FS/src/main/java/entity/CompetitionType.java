package main.java.entity;

import javax.persistence.*;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
@Table(name = "competition_type", schema = "public", catalog = "FS")
public class CompetitionType {
    private int idCompetitionType;
    private String nameCompetitionType;

    @Id
    @Column(name = "id_competition_type", nullable = false, insertable = true, updatable = true)
    public int getIdCompetitionType() {
        return idCompetitionType;
    }

    public void setIdCompetitionType(int idCompetitionType) {
        this.idCompetitionType = idCompetitionType;
    }

    @Basic
    @Column(name = "name_competition_type", nullable = false, insertable = true, updatable = true, length = 30)
    public String getNameCompetitionType() {
        return nameCompetitionType;
    }

    public void setNameCompetitionType(String nameCompetitionType) {
        this.nameCompetitionType = nameCompetitionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetitionType that = (CompetitionType) o;

        if (idCompetitionType != that.idCompetitionType) return false;
        if (nameCompetitionType != null ? !nameCompetitionType.equals(that.nameCompetitionType) : that.nameCompetitionType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompetitionType;
        result = 31 * result + (nameCompetitionType != null ? nameCompetitionType.hashCode() : 0);
        return result;
    }
}
