package stc06.gubarkov.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

public class Main  {
    public static void main(String[] args) throws Exception {
        Student student = new Student(new Date(), "Conor", "John", "Reese");
        for (Field f: student.getClass().getDeclaredFields()) {
            System.out.println(f.getName() + " " +
                                f.getType().toString());
        }

        for (Method m : student.getClass().getDeclaredMethods()) {
            System.out.println(m.getName() + " " +
                                m.getReturnType().toString() +
                                m.getParameterTypes().length);
        }

        for (Annotation a : Student.class.getAnnotations()) {
            System.out.println(a.annotationType().toString() +
                                "\t" + a.toString());
        }

        Field firstName = student.getClass().getDeclaredField("firstName");
        firstName.setAccessible(true);
        System.out.println(firstName.get(student));

        Field field = student.getClass().getSuperclass().getDeclaredField("id");
        /*Field stuId = student.getClass().getField("id");
        stuId.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setInt(stuId, stuId.getModifiers() & ~Modifier.FINAL);
        stuId.set(student, 1L);
        System.out.println(stuId.get(student));*/
    }
}
