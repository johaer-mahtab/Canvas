package com.canvas.Model.DB;

import com.canvas.Model.User;

public class Current {

    private static UserDB userDB = new UserDB();
    private static CourseDB courseDB = new CourseDB();
    private User currentUser;
    public static UserDB getUserDB() {
        return userDB;
    }
    public static void loadUserDB(UserDB userDB) {
        Current.userDB = userDB;
    }
    public static CourseDB getCourseDB() {
        return courseDB;
    }
    public static void setCourseDB(CourseDB courseDB) {
        Current.courseDB = courseDB;
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
