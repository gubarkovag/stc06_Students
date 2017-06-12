package stc06.gubarkov;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import stc06.gubarkov.models.Group;
import stc06.gubarkov.models.Student;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Student student = new Student(new Date(), "Ivan", "Ivanovich", "Ivanov");
        Group group = new Group("group1", new Date(), new Date());
        student.getGroups().add(group);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try(FileOutputStream oos =
                    new FileOutputStream("students.dat")) {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation impl = builder.getDOMImplementation();
            Document doc = impl.createDocument(null, null, null);

            Element studentObj = doc.createElement("object");
            studentObj.setAttribute("type", "Student");

            Field groupsField = null;
            for (Field f : student.getClass().getDeclaredFields()) {
                attachFieldNode(student, f, doc, studentObj);
                if (f.getName().equals("groups")) {
                    groupsField = f;
                }
            }

            for (Method m: student.getClass().getDeclaredMethods()) {
                attachMethodNode(m, doc, studentObj);
            }

            List<Group> groupList = (List<Group>)groupsField.get(student);
            if (groupList.size() > 0) {
                Element groupObj = doc.createElement("object");
                groupObj.setAttribute("type", "Group");
                studentObj.appendChild(groupObj);
                for (Group currentGroup : groupList) {
                    for (Field f : currentGroup.getClass().getDeclaredFields()) {
                        attachFieldNode(currentGroup, f, doc, groupObj);
                    }
                    for (Method m : currentGroup.getClass().getDeclaredMethods()) {
                        attachMethodNode(m, doc, groupObj);
                    }
                }
            }

            DOMSource source = new DOMSource(doc);
            // Use a Transformer for output
            StreamResult result = new StreamResult(oos);
            TransformerFactory tFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void attachFieldNode(Object fieldContainer, Field f, Document doc, Node nodeToAppendTo) {
        f.setAccessible(true);
        if (!Modifier.isTransient(f.getModifiers())) {
            Element childFieldName = doc.createElement("field");
            childFieldName.setAttribute("type", f.getType().getSimpleName().toString());
            childFieldName.setAttribute("id", f.getName());
            try {
                childFieldName.setAttribute("value", f.get(fieldContainer).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            nodeToAppendTo.appendChild(childFieldName);
        }
    }

    private static void attachMethodNode(Method m, Document doc, Node nodeToAppendTo) {
        Element childFieldName = doc.createElement("method");
        childFieldName.setAttribute("id", m.getName());
        childFieldName.setAttribute("return", m.getReturnType().getSimpleName().toString());
        for (Parameter p : m.getParameters()) {
            Element parameterFieldName = doc.createElement("arg");
            parameterFieldName.setAttribute("id", p.getName());
            parameterFieldName.setAttribute("type", p.getType().getSimpleName().toString());
            childFieldName.appendChild(parameterFieldName);
        }
        nodeToAppendTo.appendChild(childFieldName);
    }
}
