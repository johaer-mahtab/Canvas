package com.canvas;

import java.util.ArrayList;

import com.canvas.Model.DB.Current;
import com.canvas.Output.Test;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Test.tsts();
    }

    public static void initialize() {
        Current.load();
    }

    public static void end(){}

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
}
