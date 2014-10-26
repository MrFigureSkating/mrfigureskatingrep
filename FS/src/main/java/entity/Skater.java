package main.java.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
@PrimaryKeyJoinColumn(name="id_person")
public class Skater extends Person {

    private List<SkaterDiscipline> disciplines;
    private List<SkaterCoach> coaches;



    public Skater() {
    }

    public Skater(int idPerson, String name, String sex, Calendar birthday, String info, Short isReigningSkater, Short isReigningCoach, Short isReigningChoreographer) {
        super(idPerson, name, sex, birthday, info, isReigningSkater, isReigningCoach, isReigningChoreographer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skater skater = (Skater) o;

        if (getIdPerson()!= skater.getIdPerson()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getIdPerson();
    }

    @OneToMany(mappedBy = "skater")
    public List<SkaterDiscipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<SkaterDiscipline> disciplines) {
        this.disciplines = disciplines;
    }

    @OneToMany(mappedBy = "skater")
    public List<SkaterCoach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<SkaterCoach> coaches) {
        this.coaches = coaches;
    }
}
