package com.canvas;

import com.canvas.Model.DB.Current;
import com.canvas.Output.Test;

public class Main {

    public static void main(String[] args) {

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


}
