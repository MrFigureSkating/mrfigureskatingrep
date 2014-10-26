package main.java.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
public class Country {
    private String shortName;
    private String name;
    private List<Person> persons;

    @Id
    @Column(name = "short_name", nullable = false, insertable = true, updatable = true, length = 3)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (shortName != null ? !shortName.equals(country.shortName) : country.shortName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shortName != null ? shortName.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "countries")
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
