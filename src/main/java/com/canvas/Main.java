package com.canvas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.canvas.Exception.NoSuchFaculty;
import com.canvas.Exception.NoSuchStudent;
import com.canvas.Model.Faculty;
import com.canvas.Model.DB.CourseDB;
import com.canvas.Model.DB.Current;
import com.canvas.Output.Test;

public class Main {

    public static void main(String[] args) {

    }

    public static void main55(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Welcome!!! [1] Login | [2] Sign-up: ");

        
        if (in.nextInt() == 1) {

            System.out.print("[1] Faculty | [2] Student: ");
            Current.type = in.nextInt();

            //String username = JOptionPane.showInputDialog("Enter your username:");
            String username = getInputOfString("username");
            //getProperUsername(username);
            String password = getInputOfString("password");

            try {
                Current.setCurrentUser(username);
            } catch (NoSuchFaculty e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchStudent e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //validPassword(password);

            Current.getCurrentUser().displayInfo();

            if (Current.type == 1) {
                System.out.println("[1] Add New Course");
                int val = in.nextInt();

                if (val == 1) {
                    Current.getCurrentUser().addNewCourse()
                }
            } else {

            }



        } else {
            System.out.print("[1] Faculty | [2] Student");
            Current.type = in.nextInt();

            if (Current.type == 1) {
                Current.getUserDB().addNewFaculty(
                        getInputOfString("ID"),
                        getInputOfString("Password"),
                        getInputOfString("FullName"),
                        getInputOfString("Initial"),
                        getInputOfString("Office Room"),
                        getInputOfString("Office Hour"),
                        getInputOfString("Department"));

            } else {
                Current.getUserDB().addNewStudent(
                        getInputOfString("ID"),
                        getInputOfString("Password"),
                        getInputOfString("FullName"),
                        getInputOfDouble("CGPA"),
                        getInputOfInt("creditPassed"),
                        getInputOfInt("Total Credit"));
            }
        }

    }

    public static void main1(String[] args) {
        System.out.println("Hello World!");
        initialize();
        Test.tsts();
        end();
    }

    public static void initialize() {
        Current.load();
    }

    public static void end(){
        Current.save();
    }

    public static void exit(String message) {
        System.out.println(message);
        System.exit(0);
    }

    public static String joinWithComma(ArrayList<String> ids) {
        String s = "";
        for (int i = 0; i < ids.size(); i++) {
            if (i > 0) {
                s += (", ");
            }
            s += ids.get(i);
        }
        return s;
    }

    private static String getInputOfString(String fieldName) {
        System.out.print("Enter the value of " + fieldName + ": ");
        return new Scanner(System.in).nextLine();
    }

    private static int getInputOfInt(String fieldName) {
        System.out.print("Enter the value of " + fieldName + ": ");
        return new Scanner(System.in).nextInt();
    }

    private static double getInputOfDouble(String fieldName) {
        System.out.print("Enter the value of " + fieldName + ": ");
        return new Scanner(System.in).nextDouble();
    }

    private static void getProperUsername(String username) {
        while (username == null || username.isEmpty()) {
            username = JOptionPane.showInputDialog("Invalid Username. Please Try Again");
        }
        if (Current.type == 1) {
            try {
                Current.setCurrentUser(Current.getUserDB().getFaculty(username));
            } catch (NoSuchFaculty e) {
                getProperUsername(null);
            }
        } else {
            try {
                Current.setCurrentUser(Current.getUserDB().getStudent(username));
            } catch (NoSuchStudent e) {
                getProperUsername(null);
            }

        }
    }

    private static void validPassword(String password) {
        while (password == null || password.isEmpty() || !Current.getCurrentUser().matchPassword(password)) {
            password = JOptionPane.showInputDialog("Invalid password. Please Try Again");
        }
    }

}
