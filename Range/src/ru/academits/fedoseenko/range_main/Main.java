package ru.academits.fedoseenko.range_main;

import ru.academits.fedoseenko.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(-4.7, 12.7);
        Range range2 = new Range(10.6, 23.8);

        range1.setTo(2.9);
        range2.setFrom(3.2);

        System.out.printf("Диапазон 1 = [(%.1f, %.1f)]%nДиапазон 2 = [(%.1f, %.1f)]%n",
                range1.getFrom(), range1.getTo(), range2.getFrom(), range2.getTo());

        System.out.println("Длина диапазона 1 = " + range1.getLength());

        boolean isBelong = range1.isInside(15.0);
        System.out.println("Точка принадлежит диапазону 1 = " + isBelong);

        Range intersection = range1.getIntersection(range2);

        System.out.println("Диапазон пересечения двух диапазонов = [" + intersection + "]");

        System.out.println("Диапазон(ы) объединения = " + Arrays.toString(range1.getUnion(range2)));

        System.out.println("Разность диапазонов = " + Arrays.toString(range1.getDifference(range2)));
    }
}