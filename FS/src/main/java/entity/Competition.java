package main.java.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
public class Competition {
    private int idCompetition;
    private String nameCompetition;
    private String location;
    private Date startDate;
    private Date finishDate;

    @Id
    @Column(name = "id_competition", nullable = false, insertable = true, updatable = true)
    public int getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    @Basic
    @Column(name = "name_competition", nullable = false, insertable = true, updatable = true, length = 30)
    public String getNameCompetition() {
        return nameCompetition;
    }

    public void setNameCompetition(String nameCompetition) {
        this.nameCompetition = nameCompetition;
    }

    @Basic
    @Column(name = "location", nullable = false, insertable = true, updatable = true, length = 30)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "start_date", nullable = true, insertable = true, updatable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "finish_date", nullable = true, insertable = true, updatable = true)
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competition that = (Competition) o;

        if (idCompetition != that.idCompetition) return false;
        if (finishDate != null ? !finishDate.equals(that.finishDate) : that.finishDate != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (nameCompetition != null ? !nameCompetition.equals(that.nameCompetition) : that.nameCompetition != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompetition;
        result = 31 * result + (nameCompetition != null ? nameCompetition.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        return result;
    }
}
