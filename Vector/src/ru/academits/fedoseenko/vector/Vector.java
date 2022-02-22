package ru.academits.fedoseenko.vector;

import java.util.Arrays;

public class Vector {
    protected double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        this.vector = new double[n];
    }

    public Vector(Vector myVector) {
        this.vector = myVector.vector;
    }

    public Vector(double[] array) {
        this.vector = new double[array.length];
        System.arraycopy(array, 0, vector, 0, array.length);
    }

    public Vector(int n, double[] array) {
        this.vector = new double[n];

        for (int i = 0; i < n; i++) {
            if (i >= array.length) {
                vector[i] = 0;
            } else
                vector[i] = array[i];
        }
    }

    public static int getSize(Vector vector) {
        return vector.vector.length;
    }

    public Vector getAmount(Vector vector) {
        if (this.vector.length < vector.vector.length) {
            this.vector = new Vector(vector.vector.length, this.vector).vector;
        } else if (this.vector.length > vector.vector.length) {
            vector.vector = new Vector(this.vector.length, vector.vector).vector;
        }

        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] = this.vector[i] + vector.vector[i];
        }

        return this;
    }

    public Vector getDifference(Vector vector) {
        if (this.vector.length < vector.vector.length) {
            this.vector = new Vector(vector.vector.length, this.vector).vector;
        } else if (this.vector.length > vector.vector.length) {
            vector.vector = new Vector(this.vector.length, vector.vector).vector;
        }

        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] = this.vector[i] - vector.vector[i];
        }

        return this;
    }

    public Vector getMultiplicationByScalar(double scalar) {
        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] = this.vector[i] * scalar;
        }

        return this;
    }

    public Vector getUnfoldedVector() {
        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] = this.vector[i] * -1;
        }

        return this;
    }

    public double getLength() {
        double squaresSum = 0;

        for (double i : this.vector) {
            squaresSum += Math.pow(i, 2);
        }

        return Math.sqrt(squaresSum);
    }

    public double getVector(int i) {
        return this.vector[i];
    }

    public void setVector(int i, double component) {
        this.vector[i] = component;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector).replace("[", "{").replace("]", "}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vector vector1 = (Vector) o;
        return Arrays.equals(vector, vector1.vector);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }

    public static Vector getAmount(Vector vector1, Vector vector2) {
        if (vector1.vector.length < vector2.vector.length) {
            vector1.vector = new Vector(vector1.vector.length, vector1.vector).vector;
        } else if (vector1.vector.length > vector2.vector.length) {
            vector2.vector = new Vector(vector1.vector.length, vector2.vector).vector;
        }

        Vector vector3 = new Vector(vector1.vector.length);

        for (int i = 0; i < vector3.vector.length; i++) {
            vector3.vector[i] = vector1.vector[i] + vector2.vector[i];
        }

        return vector3;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        if (vector1.vector.length < vector2.vector.length) {
            vector1.vector = new Vector(vector1.vector.length, vector1.vector).vector;
        } else if (vector1.vector.length > vector2.vector.length) {
            vector2.vector = new Vector(vector1.vector.length, vector2.vector).vector;
        }

        Vector vector3 = new Vector(vector1.vector.length);

        for (int i = 0; i < vector3.vector.length; i++) {
            vector3.vector[i] = vector1.vector[i] - vector2.vector[i];
        }

        return vector3;
    }
}