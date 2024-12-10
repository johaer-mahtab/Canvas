package com.canvas.Output;

import com.canvas.Custom;
import com.canvas.Exception.NoSuch;
import com.canvas.Exception.NoSuchCourse;
import com.canvas.Model.Course;
import com.canvas.Model.Faculty;
import com.canvas.Model.Gradeable;
import com.canvas.Model.Student;
import com.canvas.Model.DB.Current;

public class ConsolePrint {

    public static int loginOrSignup() {
        System.out.print("Welcome! [1] Login | [2] Signup: ");
        return Custom.getKey();
    }

    public static int facultyOrStudent() {
        System.out.print("[1] Faculty | [2] Student: ");
        return Custom.getKey();
    }

    public static int facultyOption() {
        System.out.print("[1] Add new course | [2] Browse your courses: ");
        return Custom.getKey();
    }

    public static int studentOption() {
        System.out.print("[1] Enroll in a course | [2] Browse your courses: ");
        return Custom.getKey();
    }

    public static int facultyCourseOption() {
        System.out.print("[1] Add new gradeable | [2] Browse your gradeable: ");
        return Custom.getKey();
    }

    public static int facultyGradeableOption() {
        System.out.print("[1] Add new submission | [2] See details: ");
        return Custom.getKey();
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
                while (!Current.getCurrentUser().matchPassword(password)) {
                    password = Custom.getInputOfString("Password again");
                }
            } catch (NoSuch e) {
                Custom.exit("Couldn't find ID");
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
                    for (int i = 0; i < faculty.getCourseUIDList().size(); i++) {
                        System.out.println(i + 1 + ": " + faculty.getCourseUIDList().get(i));
                    }
                    try {
                        Course selectedCourse = faculty.getCourse(chooseCourseIndex() - 1);
                        selectedCourse.displayInfo();
                        if (facultyCourseOption() == 1) {
                            selectedCourse.addNewGradeable(
                                    Custom.getInputOfString("Type"),
                                    Custom.getInputOfInt("After"),
                                    Custom.getInputOfDouble("Total Marks"));
                        } else {
                            for (int i = 0; i < selectedCourse.getGrades().size(); i++) {
                                System.out.println(i + 1 + ": " + selectedCourse.getGrades().get(i).getType());
                            }
                            Gradeable selectedGradeable = selectedCourse.getGrades().get(Custom.getKey() - 1);
                            if (facultyGradeableOption() == 1) {
                                selectedGradeable.addNewSubmission(
                                        Custom.getInputOfString("ID"),
                                        Custom.getInputOfDouble("Scored Marks"),
                                        Custom.getInputOfString("Feedback"));
                            } else
                                System.out.println(selectedGradeable.toFacultyString());
                        }
                    } catch (NoSuchCourse e) {
                        System.out.println("Failed to get course");
                    }

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
