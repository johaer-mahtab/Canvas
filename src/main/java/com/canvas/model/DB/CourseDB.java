package com.canvas.Model.DB;

import java.util.ArrayList;

import com.canvas.Main;
import com.canvas.Model.Course;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

public class CourseDB implements Serializable, SaveLoad {
    private ArrayList<Course> courses;
    private static JFileChooser fileChooser = new JFileChooser();
    public void addNewCourse(Course course)
    {
        courses.add(course);
    }
    public void saveData() {
        try {
            fileChooser.setSelectedFile(new File("CourseDB.dat"));// Recommends a name
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

    public CourseDB loadData() {
        try {
            CourseDB courseDB;
            fileChooser.showOpenDialog(null);
            FileInputStream fileInputStream = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            courseDB = (CourseDB) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return courseDB;
        } catch (Exception e) {
            e.printStackTrace();
            Main.exit("Course DB Load Failure");
            return null;
        }
    }
}
