package stc06.gubarkov.daos;

import stc06.gubarkov.models.LessonStudent;
import stc06.gubarkov.models.Lesson;
import stc06.gubarkov.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ManagerJournal {
    private static List<LessonStudent> lessonStudents = new ArrayList<>();

    public void create(Lesson lesson, Student student) {
        lessonStudents.add(new LessonStudent(lesson.getId(), student.getId()));
    }

    public void delete(LessonStudent lessonStudent) {
        lessonStudents.remove(lessonStudent);
    }

    public void delete(Lesson lesson) {
        Predicate<LessonStudent> journalPredicate = j -> j.getLessonId() == lesson.getId();
        lessonStudents.removeIf(journalPredicate);
    }

    public void delete(Student student) {
        Predicate<LessonStudent> studentPredicate = s -> s.getStudentId() == student.getId();
    }

}
