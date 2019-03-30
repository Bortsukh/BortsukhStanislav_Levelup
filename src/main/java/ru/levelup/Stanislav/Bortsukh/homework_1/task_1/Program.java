package ru.levelup.Stanislav.Bortsukh.homework_1.task_1;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        double a = readValue();
        char fun = readFunction();
        double b = readValue();
        double result = Calculator.calc(a,fun,b);
        System.out.println("Result: "+result);
    }

    static Scanner scanner = new Scanner(System.in);

    private static double readValue(){
        System.out.println("digit is:");
        double num;
        num = scanner.nextDouble();
        return num;
    }

    public static char readFunction(){
        System.out.println("choose function:");
        char choosenFunc;
        choosenFunc = scanner.next().charAt(0);
        return choosenFunc;
    }
}
