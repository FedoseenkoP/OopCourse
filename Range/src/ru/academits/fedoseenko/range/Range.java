package ru.academits.fedoseenko.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && to >= number;
    }

    public Range getRangesIntersection(Range range) {
        if (from >= range.to || to <= range.from) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getRangesUnion(Range range) {
        if (to < range.from || range.to < from) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    public Range[] getRangesDifference(Range range) {
        if (from >= range.to || to <= range.from || from >= range.from && to <= range.to) {
            return null;
        }

        if (from >= range.from) {
            return new Range[]{new Range(range.to, to)};
        }

        if (to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{new Range(from, range.from), new Range(range.to, to)};
    }

    @Override
    public String toString() {
        return "(" + from +
                ", " + to + ")";
    }
}