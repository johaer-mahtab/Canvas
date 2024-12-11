package com.canvas;

import com.canvas.Model.DB.Current;

public class Main {

    public static void main(String[] args) {
        initialize();
        ConsolePrint.print();
        end();
    }

    public static void main1(String[] args) {
        System.out.println("Hello World!");
        initialize();
        //Test.tsts();
        ConsolePrint.print();
        end();
    }

    public static void initialize() {
        Current.load();
    }

    public static void end(){
        Current.save();
    }


}
