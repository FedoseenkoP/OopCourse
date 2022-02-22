package ru.academits.fedoseenko.methods;

import ru.academits.fedoseenko.shapes.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class Perimeter implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }

    public Shape getPerimeter(Shape[] shapes, int number) {
        if (shapes.length == 0) {
            return null;
        }

        if (number > shapes.length) {
            throw new IllegalArgumentException("Номер должен быть не больше длины массива");
        }

        if (shapes.length == 1) {
            return shapes[0];
        }

        Perimeter perimeter = new Perimeter();
        Arrays.sort(shapes, perimeter);
        return shapes[shapes.length - number];
    }
}