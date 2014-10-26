package main.java.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
@Entity
public class Program {
    private int idProgram;
    private String nameProgram;

    @Id
    @Column(name = "id_program", nullable = false, insertable = true, updatable = true)
    public int getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    @Basic
    @Column(name = "name_program", nullable = false, insertable = true, updatable = true, length = 100)
    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        if (idProgram != program.idProgram) return false;
        if (nameProgram != null ? !nameProgram.equals(program.nameProgram) : program.nameProgram != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProgram;
        result = 31 * result + (nameProgram != null ? nameProgram.hashCode() : 0);
        return result;
    }
}
