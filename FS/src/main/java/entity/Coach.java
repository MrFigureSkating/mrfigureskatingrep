package main.java.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
@PrimaryKeyJoinColumn(name="id_person")
public class Coach extends Person {
    private List<SkaterCoach> skaters;

    public Coach() {
    }

    public Coach(int idPerson, String name, String sex, Calendar birthday, String info, Short isReigningSkater, Short isReigningCoach, Short isReigningChoreographer) {
        super(idPerson, name, sex, birthday, info, isReigningSkater, isReigningCoach, isReigningChoreographer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coach coach = (Coach) o;

        if (getIdPerson() != coach.getIdPerson()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getIdPerson();
    }

    @OneToMany(mappedBy = "coach")
    public List<SkaterCoach> getSkaters() {
        return skaters;
    }

    public void setSkaters(List<SkaterCoach> skaters) {
        this.skaters = skaters;
    }
}
