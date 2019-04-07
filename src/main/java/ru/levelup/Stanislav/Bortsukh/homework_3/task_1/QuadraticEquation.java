package ru.levelup.Stanislav.Bortsukh.homework_3.task_1;

import static ru.levelup.Stanislav.Bortsukh.homework_3.task_1.CoefficientsEquation.getDouble;
import static ru.levelup.Stanislav.Bortsukh.homework_3.task_1.CoefficientsEquation.getString;

public class QuadraticEquation {
    public static void main(String[] args) {
        System.out.println("Put a");
        double a1= getDouble(getString());
        System.out.println("Put B");
        double b1= getDouble(getString());
        System.out.println("Put C");
        double c1= getDouble(getString());
        evaluation(a1,b1,c1);
    }

    double discriminantEvaluation(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    static void evaluation(double a, double b, double c) {
        QuadraticEquation ss = new QuadraticEquation();

        double discriminant = ss.discriminantEvaluation(a, b, c);

        if (discriminant > 0.0) {
            if (a!=0 && b!=0 && c!=0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println(String.format("x1 = %s, x2 = %s", x1, x2));
            }
            else if (c == 0){
                double x1 = (-b)/a;
                System.out.println(String.format("x1 = %s", x1));
            }
            else if (b==0){
                double x1 = Math.sqrt(-c/a);
                double x2 = (Math.sqrt(-c/a))*(-1);
                System.out.println(String.format("x1 = %s, x2 = %s", x1, x2));
            }
            else if (b==0 && c==0){
                double x1 = 0;
                System.out.println(String.format("x1 = %s", x1));
            }
        } else if (discriminant == 0.0) {
            System.out.println("x1 = x2 = " + (-b / (2 * a)));
        } else {
            System.out.println("solution was not found");
        }
    }
}
