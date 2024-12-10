package com.canvas.Model.DB;

import java.util.ArrayList;

import com.canvas.Custom;
import com.canvas.Exception.NoSuchCourse;
import com.canvas.Model.Course;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

public class CourseDB implements Serializable, SaveLoad {
    private ArrayList<Course> courses = new ArrayList<>();
    private static final File DB = new File("Course.DB");

    public void addNewCourse(Course course) {
        courses.add(course);
    }

    public Course getCourse(String CourseUID) throws NoSuchCourse {
        for (Course course : courses) {
            if (course.getUID().equals(CourseUID))
                return course;
        }
        throw new NoSuchCourse();
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

    public CourseDB loadData() {
        try {
            if (!DB.exists()) {
                saveData();
            }
            CourseDB courseDB;
            FileInputStream fileInputStream = new FileInputStream(DB);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            courseDB = (CourseDB) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return courseDB;
        } catch (Exception e) {
            e.printStackTrace();
            Custom.exit("Course DB Load Failure");
            return null;
        }
    }
}
