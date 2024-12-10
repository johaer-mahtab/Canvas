package com.canvas.Output;

import java.util.Scanner;

import com.canvas.Custom;
import com.canvas.Exception.NoSuch;
import com.canvas.Exception.NoSuchFaculty;
import com.canvas.Exception.NoSuchStudent;
import com.canvas.Model.DB.Current;

public class ConsolePrint {

    public static void main55(String[] args) {
    
        Scanner in = new Scanner(System.in);
    
        System.out.print("Welcome!!! [1] Login | [2] Sign-up: ");
    
        
        if (in.nextInt() == 1) {
    
            System.out.print("[1] Faculty | [2] Student: ");
            Current.type = in.nextInt();
    
            //String username = JOptionPane.showInputDialog("Enter your username:");
            String username = Custom.getInputOfString("username");
            //getProperUsername(username);
            String password = Custom.getInputOfString("password");
    
            try {
                Current.setCurrentUser(username);
            } catch (NoSuch e) {
                e.printStackTrace();
            }
            //validPassword(password);
    
            Current.getCurrentUser().displayInfo();
    
            if (Current.type == 1) {
                System.out.println("[1] Add New Course");
                int val = in.nextInt();
    
                if (val == 1) {
                    // Current.getCurrentUser().addNewCourse()
                }
            } else {
    
            }
    
    
    
        } else {
            System.out.print("[1] Faculty | [2] Student");
            Current.type = in.nextInt();
    
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
