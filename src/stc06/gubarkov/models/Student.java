package stc06.gubarkov.models;

import stc06.gubarkov.utils.UtilFunctions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends ParentModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date dateOfBirth;
    private List<Group> groups;
    private String firstName;
    private String secondName;
    private String surname;
    private List<Contact> contacts;

    public Student() {
    }

    public Student(Date dateOfBirth, String firstName, String secondName, String surname) {
        this.id = UtilFunctions.generateId();
        this.dateOfBirth = dateOfBirth;
        this.groups = new ArrayList<>();
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.contacts = new ArrayList<>();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Contact> getContacts() {
        return contacts;
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
        return ((Student)obj).id == id;
    }
}
