package org.example.tete;

import org.example.MyException;
import org.example.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//2. Разместите тесты на функцию в классе src/test/java/.../TriangleTest.java.

public class TriangleTest {
    public static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void testCalcTriangle() throws MyException {
        TriangleArea triangle = new TriangleArea();
        Assertions.assertEquals(11.976539567003485, triangle.triangleArea(4, 6, 7));
        logger.info("Позитивный тест: Сравнение фактического результата с ожидаемым результатом.");
    }

    @Test
    void testNegativeSideValue() throws MyException {
        TriangleArea triangle = new TriangleArea();
        Assertions.assertThrows(MyException.class, () -> triangle.triangleArea(20, -40, 15));
        logger.info("Негативный тест: Проверка при введении отрицательного значения одной из сторон.");
    }

    @Test
    void testZeroSideValue() throws MyException {
        TriangleArea triangle = new TriangleArea();
        Assertions.assertThrows(MyException.class, () -> triangle.triangleArea(0, 8, 9));
        logger.info("Негативный тест: Проверка при введении нулевого значения одной из сторон.");
    }

    @Test
    void testSumTwoSides() throws MyException {
        TriangleArea triangle = new TriangleArea();
        Assertions.assertThrows(MyException.class, () -> triangle.triangleArea(1, 25, 94));
        logger.info("Негативный тест: Проверка при введении значения одной из сторон, которое больше либо равно сумме двух других сторон.");
    }
}
