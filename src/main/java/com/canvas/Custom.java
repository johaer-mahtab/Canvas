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
import com.canvas.Model.DB.Current;

public class Custom {

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

    public static String getInputOfString(String fieldName) {
        System.out.print("Enter the value of " + fieldName + ": ");
        return new Scanner(System.in).nextLine();
    }

    public static int getInputOfInt(String fieldName) {
        System.out.print("Enter the value of " + fieldName + ": ");
        return new Scanner(System.in).nextInt();
    }

    public static double getInputOfDouble(String fieldName) {
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
