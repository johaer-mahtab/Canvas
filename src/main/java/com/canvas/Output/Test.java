package com.canvas.Output;

import com.canvas.Exception.NoSuchStudent;
import com.canvas.Model.Course;
import com.canvas.Model.Faculty;
import com.canvas.Model.Student;
import com.canvas.Model.DB.Current;

public class Test {

    public static void tsts() {
        Current.getUserDB().addNewStudent("012", "p", "Abc", 20, 2, 2);
        Current.getUserDB().addNewStudent("123", "p", "Abc", 20, 2, 2);
        Current.getUserDB().addNewFaculty("234", "p", "a", "A", "NAC214", "10:20-11:30","CSE");
        try {
            Student s1 = Current.getUserDB().getStudent("012");
            Student s2 = Current.getUserDB().getStudent("123");
            Faculty f = Current.getUserDB().getFaculty("234");
            f.createNewCourse("CSE115", 7, "SAC214", "MW 10:20-11:30");
            f.displayInfo();
            Course c = Current.getCourseDB().getCourse("CSE115.7");
            System.out.println();
            s1.enroll(c);
            s1.displayInfo();
            System.out.println();
            s2.enroll(c);
            s2.displayInfo();
            System.out.println();
            c.displayInfo();
            

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
