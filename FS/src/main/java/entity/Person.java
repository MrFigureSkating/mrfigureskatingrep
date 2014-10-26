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
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    private int idPerson;
    private String name;
    private String sex;
    private Calendar birthday;
    private String info;
    private Short isReigningSkater;
    private Short isReigningCoach;
    private Short isReigningChoreographer;
    private List<Country> countries;

    public Person() {
    }

    public Person(int idPerson, String name, String sex, Calendar birthday, String info, Short isReigningSkater, Short isReigningCoach, Short isReigningChoreographer) {
        this.idPerson = idPerson;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.info = info;
        this.isReigningSkater = isReigningSkater;
        this.isReigningCoach = isReigningCoach;
        this.isReigningChoreographer = isReigningChoreographer;
    }



    @Id
    @Column(name = "id_person", nullable = false, insertable = true, updatable = true)
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = false, insertable = true, updatable = true, length = 1)
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
    public Short getIsReigningSkater() {
        return isReigningSkater;
    }

    public void setIsReigningSkater(Short isReigningSkater) {
        this.isReigningSkater = isReigningSkater;
    }

    @Basic
    @Column(name = "is_reigning_coach", nullable = true, insertable = true, updatable = true)
    public Short getIsReigningCoach() {
        return isReigningCoach;
    }

    public void setIsReigningCoach(Short isReigningCoach) {
        this.isReigningCoach = isReigningCoach;
    }

    @Basic
    @Column(name = "is_reigning_choreographer", nullable = true, insertable = true, updatable = true)
    public Short getIsReigningChoreographer() {
        return isReigningChoreographer;
    }

    public void setIsReigningChoreographer(Short isReigningChoreographer) {
        this.isReigningChoreographer = isReigningChoreographer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (idPerson != person.idPerson) return false;
        if (birthday != null ? !birthday.equals(person.birthday) : person.birthday != null) return false;
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

    @Override
    public int hashCode() {
        int result = idPerson;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (isReigningSkater != null ? isReigningSkater.hashCode() : 0);
        result = 31 * result + (isReigningCoach != null ? isReigningCoach.hashCode() : 0);
        result = 31 * result + (isReigningChoreographer != null ? isReigningChoreographer.hashCode() : 0);
        return result;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="citizenship",
            joinColumns={@JoinColumn(name="id_person")},
            inverseJoinColumns={@JoinColumn(name="short_name")})
    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
