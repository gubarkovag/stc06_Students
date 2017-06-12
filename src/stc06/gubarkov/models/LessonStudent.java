package stc06.gubarkov.models;

import stc06.gubarkov.utils.UtilFunctions;

import java.io.Serializable;

public class LessonStudent implements Serializable {
    private static final long serialVersionUID = 5L;

    private Long lessonId;
    private Long studentId;

    public LessonStudent() {
    }

    public LessonStudent(Long lessonId, Long studentId) {
        this.lessonId = lessonId;
        this.studentId = studentId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public Long getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        LessonStudent lessonStudent = (LessonStudent) obj;
        return lessonStudent.lessonId == lessonId &&
               lessonStudent.studentId == studentId;
    }

    @Override
    public int hashCode() {
        return UtilFunctions.generateHashCode(studentId);
    }
}
