package ru.academits.fedoseenko.vector_main;

import ru.academits.fedoseenko.vector.Vector;

import static ru.academits.fedoseenko.vector.Vector.*;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        System.out.println("Вектор 1 = " + vector1);

        Vector vector2 = new Vector(new double[]{9, 5, 7, 12, 47, 36});
        System.out.println("Вектор 2 = " + vector2);

        Vector vector3 = new Vector(vector2);
        System.out.println("Вектор 3 = " + vector3);

        Vector vector4 = new Vector(8, new double[]{9, 14, 47, 32, 58, 36});
        System.out.println("Вектор 4 = " + vector4);

        System.out.println("Размерность вектора = " + vector2.getSize());

        Vector vector5 = new Vector(new double[]{3, 8, 6, 5, 14, 15, 28, 32});

        System.out.println("Сумма векторов = " + vector2.addVector(vector5));

        System.out.println("Разность векторов = " + vector2.subtractVector(vector5));

        System.out.println("Умножение вектора на скаляр = " + vector2.multiplyByScalar(2));

        System.out.println("Развернутый вектор = " + vector2.expandVector());

        System.out.println("Длина вектора = " + vector2.getLength());

        vector2.setVector(3, 15);

        System.out.println("Третий компонент вектора = " + vector2.getVector(3));

        Vector vector6 = new Vector(vector4);
        Vector vector7 = new Vector(vector2);

        System.out.println("Сумма векторов = " + getSum(vector6, vector7));

        System.out.println("Разность векторов = " + getDifference(vector6, vector7));

        System.out.println("Скалярное произведение векторов = " + getVectorsDotProduct(vector6, vector7));
    }
}