package com.canvas.Model.DB;

import java.util.ArrayList;

import com.canvas.Main;
import com.canvas.Exception.NoSuchFaculty;
import com.canvas.Exception.NoSuchStudent;
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

    private ArrayList<Faculty> faculties = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private static final File DB = new File("User.DB");

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
            String initial, String officeRoom, String officeHour, String department) {
        faculties.add(new Faculty(id, password, fullName, initial, officeRoom, officeHour, department));
    }

    public void addNewStudent(String id, String password, String fullName,
            double cGPA, int creditPassed, int totalCredit) {
        students.add(new Student(id, password, fullName, cGPA, creditPassed, totalCredit));
    }

    public void saveData() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(DB);
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
            if (!DB.exists()) {
                saveData();
            }
            UserDB userDB;
            FileInputStream fileInputStream = new FileInputStream(DB);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userDB = (UserDB) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return userDB;
        } catch (Exception e) {
            e.printStackTrace();
            Main.exit("User DB Load Failure");
            return null;
        }
    }
}
