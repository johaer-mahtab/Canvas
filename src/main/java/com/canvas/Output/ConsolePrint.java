package com.canvas.Output;

import java.util.Scanner;

import com.canvas.Custom;
import com.canvas.Exception.NoSuch;
import com.canvas.Exception.NoSuchFaculty;
import com.canvas.Exception.NoSuchStudent;
import com.canvas.Model.Course;
import com.canvas.Model.Faculty;
import com.canvas.Model.Student;
import com.canvas.Model.DB.Current;

public class ConsolePrint {

    public static int getKey() {
        return new Scanner(System.in).nextInt();
    }

    public static int loginOrSignup() {
        System.out.print("Welcome! [1] Login | [2] Signup: ");
        return getKey();
    }

    public static int facultyOrStudent() {
        System.out.print("[1] Faculty | [2] Student: ");
        return getKey();
    }

    public static int facultyOption() {
        System.out.print("[1] Add new course | [2] Browse your courses: ");
        return getKey();
    }

    public static int studentOption() {
        System.out.print("[1] Enroll in a course | [2] Browse your courses: ");
        return getKey();
    }

    public static int chooseCourseIndex() {
        return Custom.getInputOfInt("Course Index");
    }

    public static void print() {
    
        int curr = loginOrSignup();
        if (curr == 1) {
            Current.type = facultyOrStudent();
            
            String userid = Custom.getInputOfString("UserID");
            String password = Custom.getInputOfString("Password");

            try {
                Current.setCurrentUser(userid);
            } catch (NoSuch e) {
                e.printStackTrace();
            }

            Current.getCurrentUser().displayInfo();

            if (Current.type == 1) {

                Faculty faculty = (Faculty) Current.getCurrentUser();
                int action = facultyOption();

                if (action == 1) {
                    faculty.createNewCourse(Custom.getInputOfString("Subject"),
                                            Custom.getInputOfInt("Section"),
                                            Custom.getInputOfInt("Credit"),
                                            Custom.getInputOfString("Room"),
                                            Custom.getInputOfString("Timing"));
                } else {

                    

                }
            } else {

                Student student = (Student) Current.getCurrentUser();
                int action = studentOption();

                if (action == 1) {

                    System.out.println(Current.getCourseDB().showAllCourses());
                    student.enroll(Custom.getInputOfString("Course Unique ID"));

                } else {
                    
                    System.out.println(Custom.joinWithComma(student.getCourseUIDList()));
                    student.getDetailsOfCourse(chooseCourseIndex());

                }

            }


        } else {
            Current.type = facultyOrStudent();

            if (Current.type == 1) {
                Current.getUserDB().addNewFaculty(
                    Custom.getInputOfString("ID"),
                    Custom.getInputOfString("Password"),
                    Custom.getInputOfString("FullName"),
                    Custom.getInputOfString("Initial"),
                    Custom.getInputOfString("Office Room"),
                    Custom.getInputOfString("Office Hour"),
                    Custom.getInputOfString("Department"));
            } else {
                Current.getUserDB().addNewStudent(
                    Custom.getInputOfString("ID"),
                    Custom.getInputOfString("Password"),
                    Custom.getInputOfString("FullName"),
                    Custom.getInputOfInt("Total Credit"));
            }
        }
    
    }

}
