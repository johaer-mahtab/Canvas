package com.canvas;

import com.canvas.Model.DB.Current;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static void initialize () {
        Current.load();        
    }

    public static void exit(String message) {
        System.out.println(message);
        System.exit(0);
    }

    public static String parseIds(ArrayList<String> ids) {
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < ids.size(); i++) {
            if (i > 0) {
                res.append(", ");
            }
            res.append(ids.get(i));
        }
        return res.toString();
    }
}
