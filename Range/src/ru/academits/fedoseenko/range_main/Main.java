package ru.academits.fedoseenko.range_main;

import ru.academits.fedoseenko.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(-4.7, 15.7);
        Range range2 = new Range(10.6, 23.8);

        System.out.println("Длина диапазона = " + range1.getLength());

        boolean inside = range1.isInside(15.0);
        System.out.println("Точка принадлежит диапазону = " + inside);

        Range range3 = range1.getIntervalsIntersection(range2);

        if (range3 == null) {
            System.out.println("Интервал пересечения двух интервалов = " + null);
        } else {
            System.out.printf("Интервал пересечения двух интервалов = %.2f, %.2f", range3.getFrom(), range3.getTo());
            System.out.println();
        }

        System.out.println("Интервал(ы) объединения = " + Arrays.toString(range1.getIntervalsUnion(range2)));

        range1.setTo(28.9);
        range2.setFrom(-3.2);

        System.out.println("Разность интервалов = " + Arrays.toString(range1.getIntervalDifference(range2)));
    }
}