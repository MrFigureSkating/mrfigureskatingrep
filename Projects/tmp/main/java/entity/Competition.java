package main.java.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
public class Competition {
    private String idCompetition;
    private String nameCompetition;
    private String location;
    private Calendar startCalendar;
    private Calendar finishCalendar;
    private CompetitionType competitionTypeByIdCompetitionType;
    private List<Result> resultsByIdCompetition;

    @Id
    @Column(name = "id_competition", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(String idCompetition) {
        this.idCompetition = idCompetition;
    }

    @Basic
    @Column(name = "name_competition", nullable = false, insertable = true, updatable = true, length = 32)
    public String getNameCompetition() {
        return nameCompetition;
    }

    public void setNameCompetition(String nameCompetition) {
        this.nameCompetition = nameCompetition;
    }

    @Basic
    @Column(name = "location", nullable = false, insertable = true, updatable = true, length = 32)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "start_date", nullable = true, insertable = true, updatable = true)
    public Calendar getStartCalendar() {
        return startCalendar;
    }

    public void setStartCalendar(Calendar startCalendar) {
        this.startCalendar = startCalendar;
    }

    @Basic
    @Column(name = "finish_date", nullable = true, insertable = true, updatable = true)
    public Calendar getFinishCalendar() {
        return finishCalendar;
    }

    public void setFinishCalendar(Calendar finishCalendar) {
        this.finishCalendar = finishCalendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competition that = (Competition) o;

        if (finishCalendar != null ? !finishCalendar.equals(that.finishCalendar) : that.finishCalendar != null) return false;
        if (idCompetition != null ? !idCompetition.equals(that.idCompetition) : that.idCompetition != null)
            return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (nameCompetition != null ? !nameCompetition.equals(that.nameCompetition) : that.nameCompetition != null)
            return false;
        if (startCalendar != null ? !startCalendar.equals(that.startCalendar) : that.startCalendar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompetition != null ? idCompetition.hashCode() : 0;
        result = 31 * result + (nameCompetition != null ? nameCompetition.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startCalendar != null ? startCalendar.hashCode() : 0);
        result = 31 * result + (finishCalendar != null ? finishCalendar.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_competition_type", referencedColumnName = "id_competition_type")
    public CompetitionType getCompetitionTypeByIdCompetitionType() {
        return competitionTypeByIdCompetitionType;
    }

    public void setCompetitionTypeByIdCompetitionType(CompetitionType competitionTypeByIdCompetitionType) {
        this.competitionTypeByIdCompetitionType = competitionTypeByIdCompetitionType;
    }

    @OneToMany(mappedBy = "competitionByIdCompetition")
    public List<Result> getResultsByIdCompetition() {
        return resultsByIdCompetition;
    }

    public void setResultsByIdCompetition(List<Result> resultsByIdCompetition) {
        this.resultsByIdCompetition = resultsByIdCompetition;
    }
}
