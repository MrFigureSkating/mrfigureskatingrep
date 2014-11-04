package ru.fsinfo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
@Table(name = "competition_type", schema = "public", catalog = "FS3")
public class CompetitionType {
    private String idCompetitionType;
    private String nameCompetitionType;
    private List<Competition> competitionsByIdCompetitionType;

    @Id
    @Column(name = "id_competition_type", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdCompetitionType() {
        return idCompetitionType;
    }

    public void setIdCompetitionType(String idCompetitionType) {
        this.idCompetitionType = idCompetitionType;
    }

    @Basic
    @Column(name = "name_competition_type", nullable = false, insertable = true, updatable = true, length = 32)
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

        if (idCompetitionType != null ? !idCompetitionType.equals(that.idCompetitionType) : that.idCompetitionType != null)
            return false;
        if (nameCompetitionType != null ? !nameCompetitionType.equals(that.nameCompetitionType) : that.nameCompetitionType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompetitionType != null ? idCompetitionType.hashCode() : 0;
        result = 31 * result + (nameCompetitionType != null ? nameCompetitionType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "competitionTypeByIdCompetitionType")
    public List<Competition> getCompetitionsByIdCompetitionType() {
        return competitionsByIdCompetitionType;
    }

    public void setCompetitionsByIdCompetitionType(List<Competition> competitionsByIdCompetitionType) {
        this.competitionsByIdCompetitionType = competitionsByIdCompetitionType;
    }
}
