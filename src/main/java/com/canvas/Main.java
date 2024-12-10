package com.canvas;

import java.util.ArrayList;
import java.util.Scanner;

import com.canvas.Model.Faculty;
import com.canvas.Model.DB.Current;
import com.canvas.Output.Test;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome!!! [1] Login | [2] Sign-up");

        Current.type = in.nextInt();

        if (Current.type == 1) {

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
        Test.tsts();
    }

    public static void initialize() {
        Current.load();
    }

    public static void end() {
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
        System.out.print("Enter the value of: " + fieldName);
        return new Scanner(System.in).nextLine();
    }

    private static int getInputOfInt(String fieldName) {
        System.out.print("Enter the value of: " + fieldName);
        return new Scanner(System.in).nextInt();
    }

    private static double getInputOfDouble(String fieldName) {
        System.out.print("Enter the value of: " + fieldName);
        return new Scanner(System.in).nextDouble();
    }

}
