package ru.levelup.Stanislav.Bortsukh.homework_3.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoefficientsEquation {
    public static String getString() {
        String str = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return str;
    }
    public static double getDouble(String inStr) {
        double number = 0;
        try {
            number = Double.parseDouble(inStr);
        }catch(NumberFormatException e){
            System.out.println("it is not digit");
            getDouble(getString());
        }
        return number;
    }
}
