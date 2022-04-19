package ru.academits.fedoseenko.vector;

import java.util.Arrays;

public class Vector {
    private double[] elements;

    public Vector(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException(length + "must be > 0");
        }

        elements = new double[length];
    }

    public Vector(Vector vector) {
        elements = Arrays.copyOf(vector.elements, vector.elements.length);
    }

    public Vector(double[] array) {
        elements = Arrays.copyOf(array, array.length);
    }

    public Vector(int length, double[] array) {
        elements = Arrays.copyOf(array, length);
    }

    public int getSize() {
        return elements.length;
    }

    public Vector addVector(Vector vector) {
        if (elements.length < vector.elements.length) {
            elements = Arrays.copyOf(elements, vector.elements.length);
        }

        for (int i = 0; i < vector.elements.length; i++) {
            elements[i] += vector.elements[i];
        }

        return this;
    }

    public Vector subtractVector(Vector vector) {
        if (elements.length < vector.elements.length) {
            elements = Arrays.copyOf(elements, vector.elements.length);
        }

        for (int i = 0; i < vector.elements.length; i++) {
            elements[i] -= vector.elements[i];
        }

        return this;
    }

    public Vector multiplyByScalar(double scalar) {
        for (int i = 0; i < elements.length; i++) {
            elements[i] *= scalar;
        }

        return this;
    }

    public Vector expandVector() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] *= -1;
        }

        return this;
    }

    public double getLength() {
        double squaresSum = 0;

        for (double number : elements) {
            squaresSum += number * number;
        }

        return Math.sqrt(squaresSum);
    }

    public double getVector(int index) {
        return elements[index];
    }

    public void setVector(int index, double component) {
        elements[index] = component;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;
        return Arrays.equals(elements, vector.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        return new Vector(vector1.addVector(vector2));
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        return new Vector(vector1.subtractVector(vector2));
    }

    public static double getVectorsDotProduct(Vector vector1, Vector vector2) {
        double sum = 0;
        int minLength = Math.min(vector1.elements.length, vector2.elements.length);

        for (int i = 0; i < minLength; i++) {
            sum += vector1.elements[i] * vector2.elements[i];
        }

        return sum;
    }
}