package org.example;

public class TriangleArea {
//1. Напишите функцию, вычисляющую площадь треугольника по трём сторонам (int a, int b, int c). Разместите класс с функцией в src/org.example.main/java.

    // Формула: S = √(p(p - a)(p - b)(p - c)), где p — полупериметр.
    public double triangleArea(double a, double b, double c) throws MyException {
        if (rightValues(a, b, c));
        double p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;
    }

    private static boolean rightValues(double a, double b, double c) throws MyException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new MyException ("Неправильная величина одной из сторон треугольника. Нужна корректировка.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new MyException("Таких треугольников не существует!");
        }
        return false;
    }
}