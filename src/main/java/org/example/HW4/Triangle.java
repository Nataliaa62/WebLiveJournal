package org.example.HW4;

public class Triangle {

public static double area (int a, int b, int c) throws MyException {
    if((a<0 || b<0 || c<0)) throw new MyException("Сторона треугольника не может быть отрицательным числом");
    if((a==0 || b==0 || c==0)) throw new MyException("Сторона треугольника не может быть равна 0");
    if((a+b<c || c+b<a || a+c<b)) throw new MyException("Сумма двух сторон меньше третьей. Это не треугольник");

    double p = (double) (a + b + c ) / 2.0;
    double s = Math.sqrt((p*(p-a)*(p-b)*(p-c)));
    return s;
}
}
