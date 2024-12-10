package com.canvas.Model.DB;

import java.util.ArrayList;

import com.canvas.Main;
import com.canvas.Exception.NoSuchFaculty;
import com.canvas.Exception.NoSuchStudent;
import com.canvas.Model.Course;
import com.canvas.Model.Faculty;
import com.canvas.Model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

public class UserDB implements Serializable, SaveLoad {

    private ArrayList<Faculty> faculties;
    private ArrayList<Student> students;
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

    public UserDB loadData() {
        try {
            UserDB userDB;
            fileChooser.showOpenDialog(null);
            FileInputStream fileInputStream = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userDB = (UserDB) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return userDB;
        } catch (Exception e) {
            e.printStackTrace();
            Main.exit("Load Failure");
            return null;
        }
    }
}
