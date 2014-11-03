package main.java.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
@Entity
public class Program {
    private String idProgram;
    private String nameProgram;
    private List<SkaterProgram> skaterProgramsByIdProgram;

    @Id
    @Column(name = "id_program", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
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

        if (idProgram != null ? !idProgram.equals(program.idProgram) : program.idProgram != null) return false;
        if (nameProgram != null ? !nameProgram.equals(program.nameProgram) : program.nameProgram != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProgram != null ? idProgram.hashCode() : 0;
        result = 31 * result + (nameProgram != null ? nameProgram.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "programByIdProgram")
    public List<SkaterProgram> getSkaterProgramsByIdProgram() {
        return skaterProgramsByIdProgram;
    }

    public void setSkaterProgramsByIdProgram(List<SkaterProgram> skaterProgramsByIdProgram) {
        this.skaterProgramsByIdProgram = skaterProgramsByIdProgram;
    }
}
