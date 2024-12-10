package com.canvas.Model.DB;

import com.canvas.Model.User;

public class Current {

    private static UserDB userDB = new UserDB();
    private static CourseDB courseDB = new CourseDB();
    private User currentUser;
    public static int type;

    public static void load() {
        userDB = new UserDB().loadData();
        courseDB = new CourseDB().loadData();
    }

    public static void save(){
        userDB.saveData();
        courseDB.saveData();
    }

    public static UserDB getUserDB() {
        return userDB;
    }

    public static CourseDB getCourseDB() {
        return courseDB;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
