package ru.fsinfo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
@PrimaryKeyJoinColumn(name="id_coach")
public class Coach extends Person {
//    private String idCoach;
//    private Person personByIdCoach;
    private List<SkaterCoach> skaterCoachesByIdCoach;

//    @Id
//    @Column(name = "id_coach", nullable = false, insertable = true, updatable = true, length = 32)
//    public String getIdCoach() {
//        return idCoach;
//    }
//
//    public void setIdCoach(String idCoach) {
//        this.idCoach = idCoach;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coach coach = (Coach) o;

        if (getIdPerson() != null ? !getIdPerson().equals(coach.getIdPerson()) : coach.getIdPerson() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getIdPerson() != null ? getIdPerson().hashCode() : 0;
    }

//    @OneToOne
//    @JoinColumn(name = "id_coach", referencedColumnName = "id_person", nullable = false)
//    public Person getPersonByIdCoach() {
//        return personByIdCoach;
//    }
//
//    public void setPersonByIdCoach(Person personByIdCoach) {
//        this.personByIdCoach = personByIdCoach;
//    }

    @OneToMany(mappedBy = "coachByIdCoach")
    public List<SkaterCoach> getSkaterCoachesByIdCoach() {
        return skaterCoachesByIdCoach;
    }

    public void setSkaterCoachesByIdCoach(List<SkaterCoach> skaterCoachesByIdCoach) {
        this.skaterCoachesByIdCoach = skaterCoachesByIdCoach;
    }
}
