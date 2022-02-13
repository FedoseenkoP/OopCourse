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

    public Range getIntervalsIntersection(Range myRange) {
        if (from >= myRange.to || to <= myRange.from) {
            return null;
        }
        return new Range(Math.max(from, myRange.from), Math.min(to, myRange.to));
    }

    public Range[] getIntervalsUnion(Range myRange) {
        if (to < myRange.from || myRange.to < from) {
            return new Range[]{this, myRange};
        }
        return new Range[]{new Range(Math.min(from, myRange.from), Math.max(to, myRange.to))};
    }

    public Range[] getIntervalDifference(Range myRange) {
        if (from >= myRange.to || to <= myRange.from || from >= myRange.from && to <= myRange.to) {
            return new Range[]{};
        } else if (from >= myRange.from) {
            return new Range[]{new Range(myRange.to, to)};
        } else if (to <= myRange.to) {
            return new Range[]{new Range(from, myRange.from)};
        }
        return new Range[]{new Range(from, myRange.from), new Range(myRange.to, to)};
    }

    @Override
    public String toString() {
        return "from=" + from +
                ", to=" + to;
    }
}