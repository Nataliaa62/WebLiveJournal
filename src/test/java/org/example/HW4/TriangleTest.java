package org.example.HW4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @Test
    void test() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(32.24, triangle.area(9, 9, 8), 0.01);
    }

   @ParameterizedTest
   @CsvSource({"9, 9, 8, 32.24"})
    void testWithCsvSource(int a, int b, int c, double result) throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(result,triangle.area(a,b,c), 0.01);

    }


    @Test
    void testExceptionCheckNull() {
        Triangle triangle = new Triangle();
        MyException thrown = Assertions.assertThrows(MyException.class, () -> {
            Assertions.assertEquals(1, triangle.area(9, 0, 3), 0.01);
        }, "Исключение не возникает");

        Assertions.assertEquals("Сторона треугольника не может быть равна 0", thrown.getMessage());
    }


    @Test
    void testExceptionCheckNegativeNumber() {
        Triangle triangle = new Triangle();
        MyException thrown = Assertions.assertThrows(MyException.class, () -> {
            Assertions.assertEquals(1, triangle.area(9, -1, 3), 0.01);
        }, "Исключение не возникает");

        Assertions.assertEquals("Сторона треугольника не может быть отрицательным числом", thrown.getMessage());
    }


    @Test
    void testExceptionCheckSummSide() {
        Triangle triangle = new Triangle();
        MyException thrown = Assertions.assertThrows(MyException.class, () -> {
            Assertions.assertEquals(1, triangle.area(2, 3, 7), 0.01);
        }, "Исключение не возникает");

        Assertions.assertEquals("Сумма двух сторон меньше третьей. Это не треугольник", thrown.getMessage());
    }




}


