package stc06.gubarkov.models;

import stc06.gubarkov.utils.UtilFunctions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contact extends ParentModel implements Serializable {
    private static final long serialVersionUID = 3L;

    private String value;
    private ContactType type;
    private List<Student> students;

    public Contact() {
    }

    public Contact(String value, ContactType type) {
        this.id = UtilFunctions.generateId();
        this.value = value;
        this.type = type;
        this.students = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return ((Contact)obj).id == id;
    }

    @Override
    public int hashCode() {
        return UtilFunctions.generateHashCode(id);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
