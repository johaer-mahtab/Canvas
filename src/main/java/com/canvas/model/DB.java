package com.canvas.Model;

import java.util.ArrayList;

import com.canvas.Main;
import com.canvas.Exception.NoSuchFaculty;
import com.canvas.Exception.NoSuchStudent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

public class DB implements Serializable {

    private ArrayList<Faculty> faculties;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private static JFileChooser fileChooser = new JFileChooser();

    public Faculty getFaculty(String id) throws NoSuchFaculty {
        for (Faculty faculty : faculties) {
            if (faculty.getId().equals(id))
                return faculty;
        }
        throw new NoSuchFaculty();
    }

    public Student getStudent(String id) throws NoSuchStudent {
        for (Student student : students) {
            if (student.getId().equals(id))
                return student;
        }
        throw new NoSuchStudent();
    }

    public void addNewFaculty(String id, String password, String fullName,
            String initial, String officeRoom, String department) {
        faculties.add(new Faculty(id, password, fullName, initial, officeRoom, department));
    }

    public void addNewStudent(String id, String password, String fullName,
            double cGPA, int creditPassed, int totalCredit) {
        students.add(new Student(id, password, fullName, cGPA, creditPassed, totalCredit));
    }

    public void addNewCourse(String subject, int section, String room, String timing, Faculty faculty) {
        courses.add(new Course(subject, section, room, timing, faculty));
    }

    public void saveData() {
        try {
            fileChooser.setSelectedFile(new File("database.dat"));// Recommends a name
            fileChooser.showSaveDialog(null);
            FileOutputStream fileOutputStream = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("error saving");
            e.printStackTrace();
        }
    }

    public DB loadData() {
        try {
            DB returnData;
            fileChooser.showOpenDialog(null);
            FileInputStream fileInputStream = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            returnData = (DB) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return returnData;
        } catch (Exception e) {
            e.printStackTrace();
            Main.exit("Load Failure");
            return null;
        }
    }
}
