package ru.academits.fedoseenko.range_main;

import ru.academits.fedoseenko.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(-4.7, 12.7);
        Range range2 = new Range(10.6, 23.8);

        System.out.println("Длина диапазона = " + range1.getLength());

        boolean inside = range1.isInside(15.0);
        System.out.println("Точка принадлежит диапазону = " + inside);

        Range range3 = range1.getRangesIntersection(range2);

        System.out.println("Интервал пересечения двух интервалов = " + range3);

        System.out.println("Интервал(ы) объединения = " + Arrays.toString(range1.getRangesUnion(range2))
                .replace("[", "")
                .replace("]", ""));

        System.out.println("Конец первого интервала = " + range1.getTo());
        System.out.println("Начало второго интервала = " + range2.getFrom());

        range1.setTo(2.9);
        range2.setFrom(3.2);

        System.out.println("Разность интервалов = " + Arrays.toString(range1.getRangesDifference(range2))
                .replace("[", "")
                .replace("]", ""));
    }
}