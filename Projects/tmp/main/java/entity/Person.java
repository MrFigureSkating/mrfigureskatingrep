package main.java.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    private String idPerson;
    private String name;
    private String sex;
    private Calendar birthday;
    private String info;
    private Boolean isReigningSkater;
    private Boolean isReigningCoach;
    private Boolean isReigningChoreographer;
//    private Choreographer choreographerByIdPerson;
//    private List<Citizenship> citizenshipsByIdPerson;
//    private Coach coachByIdPerson;
//    private Skater skaterByIdPerson;
//    @OneToOne(mappedBy = "personByIdSkater")
//    public Skater getSkaterByIdPerson() {
//        return skaterByIdPerson;
//    }
//
//    public void setSkaterByIdPerson(Skater skaterByIdPerson) {
//        this.skaterByIdPerson = skaterByIdPerson;
//    }
    private List<Country> countriesByPersonId;

    @Id
    @Column(name = "id_person", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = true, insertable = true, updatable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday", nullable = true, insertable = true, updatable = true)
    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "info", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "is_reigning_skater", nullable = true, insertable = true, updatable = true)
    public Boolean getIsReigningSkater() {
        return isReigningSkater;
    }

    public void setIsReigningSkater(Boolean isReigningSkater) {
        this.isReigningSkater = isReigningSkater;
    }

    @Basic
    @Column(name = "is_reigning_coach", nullable = true, insertable = true, updatable = true)
    public Boolean getIsReigningCoach() {
        return isReigningCoach;
    }

    public void setIsReigningCoach(Boolean isReigningCoach) {
        this.isReigningCoach = isReigningCoach;
    }

    @Basic
    @Column(name = "is_reigning_choreographer", nullable = true, insertable = true, updatable = true)
    public Boolean getIsReigningChoreographer() {
        return isReigningChoreographer;
    }

    public void setIsReigningChoreographer(Boolean isReigningChoreographer) {
        this.isReigningChoreographer = isReigningChoreographer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (birthday != null ? !birthday.equals(person.birthday) : person.birthday != null) return false;
        if (idPerson != null ? !idPerson.equals(person.idPerson) : person.idPerson != null) return false;
        if (info != null ? !info.equals(person.info) : person.info != null) return false;
        if (isReigningChoreographer != null ? !isReigningChoreographer.equals(person.isReigningChoreographer) : person.isReigningChoreographer != null)
            return false;
        if (isReigningCoach != null ? !isReigningCoach.equals(person.isReigningCoach) : person.isReigningCoach != null)
            return false;
        if (isReigningSkater != null ? !isReigningSkater.equals(person.isReigningSkater) : person.isReigningSkater != null)
            return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (sex != null ? !sex.equals(person.sex) : person.sex != null) return false;

        return true;
    }

//    @OneToOne(mappedBy = "personByIdChoreographer")
//    public Choreographer getChoreographerByIdPerson() {
//        return choreographerByIdPerson;
//    }
//
//    public void setChoreographerByIdPerson(Choreographer choreographerByIdPerson) {
//        this.choreographerByIdPerson = choreographerByIdPerson;
//    }

//    @OneToMany(mappedBy = "personByIdPerson")
//    public List<Citizenship> getCitizenshipsByIdPerson() {
//        return citizenshipsByIdPerson;
//    }
//
//    public void setCitizenshipsByIdPerson(List<Citizenship> citizenshipsByIdPerson) {
//        this.citizenshipsByIdPerson = citizenshipsByIdPerson;
//    }

//    @OneToOne(mappedBy = "personByIdCoach")
//    public Coach getCoachByIdPerson() {
//        return coachByIdPerson;
//    }
//
//    public void setCoachByIdPerson(Coach coachByIdPerson) {
//        this.coachByIdPerson = coachByIdPerson;
//    }

    @Override
    public int hashCode() {
        int result = idPerson != null ? idPerson.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (isReigningSkater != null ? isReigningSkater.hashCode() : 0);
        result = 31 * result + (isReigningCoach != null ? isReigningCoach.hashCode() : 0);
        result = 31 * result + (isReigningChoreographer != null ? isReigningChoreographer.hashCode() : 0);
        return result;
    }

    @ManyToMany
    @JoinTable(name = "citizenship",/*, catalog = "FS3", schema = "public"*/
            joinColumns = @JoinColumn(name = "id_person", referencedColumnName = "id_person", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "short_name", referencedColumnName = "short_name", nullable = false))
    public List<Country> getCountriesByPersonId() {
        return countriesByPersonId;
    }

    public void setCountriesByPersonId(List<Country> countriesByPersonId) {
        this.countriesByPersonId = countriesByPersonId;
    }
}
