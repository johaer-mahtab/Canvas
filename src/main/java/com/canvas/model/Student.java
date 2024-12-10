package com.canvas.Model;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;

import com.canvas.Custom;
import com.canvas.Exception.NoSuchCourse;
import com.canvas.Model.DB.Current;

public class Student extends User {

    private double cGP = 0;
    private int creditPassed = 0;
    private int totalCredit;
    private ArrayList<String> courseUIDList = new ArrayList<>();

    public Student(String id, String password, String fullName, int totalCredit) {
        super(id, password, fullName);
        this.totalCredit = totalCredit;
    }

    public void updateCGPA(double gP, int credit) {
        cGP += gP;
        creditPassed += credit;
    }

    public double getCGPA() {
        return cGP / creditPassed;
    }

    public void enroll(Course course) {
        courseUIDList.add(course.getUID());
        course.addStudent(getId());
    }

    public String getDetailsOfCourse(int index) {
        String s = "";
        Course c;
        try {
            c = Current.getCourseDB().getCourse(courseUIDList.get(index));
            s += c.toString();
            for (Gradeable gradeable : c.getGrades())
                for (Submission submission : gradeable.getSubmissions())
                    if (submission.equals(getId()))
                        s += "\n" + gradeable.toString() + "\n" + submission.toStudentString();
        } catch (NoSuchCourse e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("DB Corrupted");
        }
        return s;
    }

    @Override
    public void displayInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + "\nCGPA: " + getCGPA() + "\nCredit Passed: " + creditPassed + "\nTotal Credit: "
                + totalCredit
                + "\nCourses: " + Custom.joinWithComma(courseUIDList);
    }

}
