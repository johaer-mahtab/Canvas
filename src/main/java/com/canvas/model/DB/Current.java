package com.canvas.Model.DB;

import com.canvas.Exception.NoSuchFaculty;
import com.canvas.Exception.NoSuchStudent;
import com.canvas.Model.User;

public class Current {

    private static UserDB userDB = new UserDB();
    private static CourseDB courseDB = new CourseDB();
    private static User currentUser;
    public static int type;

    public static void load() {
        userDB = new UserDB().loadData();
        courseDB = new CourseDB().loadData();
    }

    public static void save() {
        userDB.saveData();
        courseDB.saveData();
    }

    public static UserDB getUserDB() {
        return userDB;
    }

    public static CourseDB getCourseDB() {
        return courseDB;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Current.currentUser = currentUser;
    }

    public static void setCurrentUser(String userID) throws NoSuchFaculty, NoSuchStudent {
        if (type == 1) {
            setCurrentUser(userDB.getFaculty(userID));
        } else {
            setCurrentUser(userDB.getStudent(userID));
        }
    }
}
