package ru.fsinfo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
@PrimaryKeyJoinColumn(name="id_choreographer")
public class Choreographer extends Person {
//    private String idChoreographer;
//    private Person personByIdChoreographer;
    private List<SkaterProgram> skaterProgramsByIdChoreographer;

//    @Id
//    @Column(name = "id_choreographer", nullable = false, insertable = true, updatable = true, length = 32)
//    public String getIdChoreographer() {
//        return idChoreographer;
//    }
//
//    public void setIdChoreographer(String idChoreographer) {
//        this.idChoreographer = idChoreographer;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Choreographer that = (Choreographer) o;

        if (getIdPerson() != null ? !getIdPerson().equals(that.getIdPerson()) : that.getIdPerson() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getIdPerson() != null ? getIdPerson().hashCode() : 0;
    }

//    @OneToOne
//    @JoinColumn(name = "id_choreographer", referencedColumnName = "id_person", nullable = false)
//    public Person getPersonByIdChoreographer() {
//        return personByIdChoreographer;
//    }
//
//    public void setPersonByIdChoreographer(Person personByIdChoreographer) {
//        this.personByIdChoreographer = personByIdChoreographer;
//    }

    @OneToMany(mappedBy = "choreographerByIdChoreographer")
    public List<SkaterProgram> getSkaterProgramsByIdChoreographer() {
        return skaterProgramsByIdChoreographer;
    }

    public void setSkaterProgramsByIdChoreographer(List<SkaterProgram> skaterProgramsByIdChoreographer) {
        this.skaterProgramsByIdChoreographer = skaterProgramsByIdChoreographer;
    }
}
