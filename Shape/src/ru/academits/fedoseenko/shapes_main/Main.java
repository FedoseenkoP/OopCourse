package ru.academits.fedoseenko.shapes_main;

import ru.academits.fedoseenko.shapes_comparators.AreaComparator;
import ru.academits.fedoseenko.shapes_comparators.PerimeterComparator;
import ru.academits.fedoseenko.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getAreaShape(Shape[] shapes, int number) {
        if (shapes.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        if (number > shapes.length) {
            throw new IllegalArgumentException("Номер должен быть не больше длины массива");
        }

        Arrays.sort(shapes, new AreaComparator());
        return shapes[shapes.length - number];
    }

    public static Shape getPerimeterShape(Shape[] shapes, int number) {
        if (shapes.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        if (number > shapes.length) {
            throw new IllegalArgumentException("Номер должен быть не больше длины массива");
        }

        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[shapes.length - number];
    }

    public static void main(String[] args) {
        Square square1 = new Square(12.3);

        System.out.println("Ширина квадрата = " + square1.getWidth());
        System.out.println("Высота квадрата = " + square1.getHeight());
        System.out.println("Площадь квадрата = " + square1.getArea());
        System.out.println("Периметр квадрата = " + square1.getPerimeter());
        System.out.println();

        Triangle triangle1 = new Triangle(-3.2, -2.8, -4.5, 4.9, 5.6, 3.3);

        System.out.println("Ширина треугольника = " + triangle1.getWidth());
        System.out.println("Высота треугольника = " + triangle1.getHeight());
        System.out.println("Площадь треугольника = " + triangle1.getArea());
        System.out.println("Периметр треугольника = " + triangle1.getPerimeter());
        System.out.println();

        Rectangle rectangle1 = new Rectangle(4.6, 7.8);

        System.out.println("Ширина прямоугольника = " + rectangle1.getWidth());
        System.out.println("Высота прямоугольника = " + rectangle1.getHeight());
        System.out.println("Площадь прямоугольника = " + rectangle1.getArea());
        System.out.println("Периметр прямоугольника = " + rectangle1.getPerimeter());
        System.out.println();

        Circle circle1 = new Circle(11.3);

        System.out.println("Ширина окружности = " + circle1.getWidth());
        System.out.println("Высота окружности = " + circle1.getHeight());
        System.out.println("Площадь окружности = " + circle1.getArea());
        System.out.println("Периметр окружности = " + circle1.getPerimeter());
        System.out.println();

        Shape[] shapes = {
                new Square(13.2),
                new Square(18.9),
                new Triangle(-4.5, -3.7, -14.5, 15.8, 10.6, 12.3),
                new Triangle(-25.5, -14.7, 17.6, -22.8, 35.6, 14.3),
                new Rectangle(14.3, 12.7),
                new Rectangle(3.6, 18.8),
                new Rectangle(21.4, 8.5),
                new Circle(17.4),
                new Circle(10.5),
                new Circle(21.2)
        };

        System.out.println("Фигура с максимальной площадью: " + getAreaShape(shapes, 1));

        System.out.println("Фигура со вторым по величине периметром: " + getPerimeterShape(shapes, 2));

        System.out.println("Радиус окружности = " + circle1.getRadius());
        System.out.println("Сторона квадрата = " + square1.getSideLength());
        System.out.printf("Координаты вершин треугольника = (%.1f;%.1f; %.1f;%.1f; %.1f;%.1f)",
                triangle1.getX1(),
                triangle1.getY1(),
                triangle1.getX2(),
                triangle1.getY2(),
                triangle1.getX3(),
                triangle1.getY3());
    }
}