package com.epam.oval.entity;

import java.util.Objects;

public class Parameters {

    private final double perimeter;
    private final double area;

    public Parameters(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parameters that = (Parameters) o;
        if (Double.compare(that.perimeter, perimeter) != 0) {
            return false;
        }
        return Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(perimeter, area);
    }
}
