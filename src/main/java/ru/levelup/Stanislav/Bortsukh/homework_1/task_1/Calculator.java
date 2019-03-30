package ru.levelup.Stanislav.Bortsukh.homework_1.task_1;

public class Calculator {
    public static double calc(double a,char fun, double b){
        double result;
        switch (fun){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
            case '^':
                result = 1;
                for(int i=0; i<b; i++){
                    result*=a;
                }
                break;
            default:
                System.out.println("Unknown operation");
                result = 0;
        }
        return result;
    }
}
