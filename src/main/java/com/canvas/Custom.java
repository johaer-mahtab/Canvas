package com.canvas;

import java.util.ArrayList;
import java.util.Scanner;

public class Custom {
    private static Scanner scanner = new Scanner(System.in);

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
        return scanner.nextLine().trim();
    }

    public static int getInputOfInt(String fieldName) {
        System.out.print("Enter the value of " + fieldName + ": ");
        return scanner.nextInt();
    }

    public static double getInputOfDouble(String fieldName) {
        System.out.print("Enter the value of " + fieldName + ": ");
        return scanner.nextDouble();
    }
}
