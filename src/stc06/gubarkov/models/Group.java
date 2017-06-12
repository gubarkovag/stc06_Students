package stc06.gubarkov.models;

import stc06.gubarkov.utils.UtilFunctions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group extends ParentModel implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name;
    private Date started;
    private Date finished;
    private transient List<Student> students;

    public Group() {
    }

    public Group(String name, Date started, Date finished) {
        this.id = UtilFunctions.generateId();
        this.name = name;
        this.started = started;
        this.finished = finished;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public int hashCode() {
        return UtilFunctions.generateHashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return ((Group)obj).id == id;
    }
}
