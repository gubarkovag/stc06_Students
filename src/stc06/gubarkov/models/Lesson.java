package stc06.gubarkov.models;

import stc06.gubarkov.utils.UtilFunctions;

import java.io.Serializable;
import java.util.Date;

public class Lesson extends ParentModel implements Serializable {
    private static final long serialVersionUID = 4L;

    private String name;
    private Date started;
    private Date finished;
    private Integer lessonHallNum;
    private String subject;
    private String lector;
    private Long groupId;

    public Lesson(String name, Date started, Date finished, Integer lessonHallNum, String subject, String lector, Long groupId) {
        this.id = UtilFunctions.generateId();
        this.name = name;
        this.started = started;
        this.finished = finished;
        this.lessonHallNum = lessonHallNum;
        this.subject = subject;
        this.lector = lector;
        this.groupId = groupId;
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

    public Integer getLessonHallNum() {
        return lessonHallNum;
    }

    public void setLessonHallNum(Integer lessonHallNum) {
        this.lessonHallNum = lessonHallNum;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return ((Lesson)obj).id == id;
    }

    @Override
    public int hashCode() {
        return UtilFunctions.generateHashCode(id);
    }
}
