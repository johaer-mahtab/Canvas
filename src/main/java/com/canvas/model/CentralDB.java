package com.canvas.Model;

import java.util.ArrayList;

import com.canvas.Exception.NoSuchFaculty;
import com.canvas.Exception.NoSuchStudent;

public class CentralDB {

    private static ArrayList<Faculty> faculties;
    private static ArrayList<Student> students;
    private static ArrayList<Course> courses;

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
}
