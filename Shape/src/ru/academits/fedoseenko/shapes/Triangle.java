package ru.academits.fedoseenko.shapes;

public class Triangle implements Shape {
    private static double x1;
    private static double y1;
    private static double x2;
    private static double y2;
    private static double x3;
    private static double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        Triangle.x1 = x1;
        Triangle.y1 = y1;
        Triangle.x2 = x2;
        Triangle.y2 = y2;
        Triangle.x3 = x3;
        Triangle.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getY3() {
        return y3;
    }

    private static double getSideLength(int side) {
        if (side < 1 || side > 3) {
            throw new IllegalArgumentException("Номер стороны треугольника должен быть от 1 до 3");
        }

        if (side == 1) {
            return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        }

        if (side == 2) {
            return Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        }

        return Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(1) + getSideLength(2) + getSideLength(3);
    }

    @Override
    public String toString() {
        return "Triangle (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return x1 == x1 && y1 == y1 && x2 == x2 && y2 == y2 && x3 == x3 && y3 == y3;
    }
}